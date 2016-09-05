package chess.domain.service.account;


import chess.core.mapping.IMappingService;
import chess.domain.service.account.command.*;
import chess.domain.service.account.representation.AccountRepresentation;
import chess.domain.service.auth.command.LoginCommand;
import chess.domain.service.shared.command.SharedCommand;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chess.core.common.PasswordHelper;
import chess.core.enums.EnableStatus;
import chess.core.exception.ExistException;
import chess.core.exception.NoFoundException;
import chess.core.util.CoreStringUtils;
import chess.domain.model.account.Account;
import chess.domain.model.account.IAccountRepository;
import chess.domain.model.role.Role;
import chess.domain.service.role.IRoleService;
import chess.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository<Account, String> accountRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public Pagination<AccountRepresentation> pagination(ListAccountCommand command) {
        command.verifyPage();
        command.verifyPageSize(30);
        List<Criterion> criterionList = new ArrayList<Criterion>();
        if (!CoreStringUtils.isEmpty(command.getUserName())) {
            criterionList.add(Restrictions.like("userName", command.getUserName(), MatchMode.ANYWHERE));
        }
        if (null != command.getStatus() && command.getStatus() != EnableStatus.ALL) {
            criterionList.add(Restrictions.eq("status", command.getStatus()));
        }
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.asc("createDate"));

        Pagination<Account> pagination = accountRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
        List<AccountRepresentation> data = mappingService.mapAsList(pagination.getData(), AccountRepresentation.class);
        return new Pagination<>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    public List<AccountRepresentation> list(ListAccountCommand command) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(Order.desc("createDate"));


        List<Account> data = accountRepository.list(criterionList, orderList);
        return mappingService.mapAsList(data, AccountRepresentation.class);
    }

    @Override
    public AccountRepresentation searchByID(String id) {
        Account account = accountRepository.getById(id);
        if (null == account) {
            throw new NoFoundException("没有找到ID[" + id + "]的Account数据");
        }

        return mappingService.map(account, AccountRepresentation.class, false);
    }

    @Override
    public AccountRepresentation searchByAccountName(String userName) {
        Account account = accountRepository.searchByAccountName(userName);
        return mappingService.map(account, AccountRepresentation.class, false);
    }

    @Override
    public AccountRepresentation create(CreateAccountCommand command) {
        List<Role> roleList = roleService.searchByIDs(command.getRoles());
        if (null != this.searchByAccountName(command.getUserName())) {
            throw new ExistException("userName[" + command.getUserName() + "]的Account数据已存在");
        }
        String salt = PasswordHelper.getSalt();
        String password = PasswordHelper.encryptPassword(command.getPassword(), salt);
        for (Role item : roleList) {
            if (item.getName().equals("admin")) {
                Account account = new Account(command.getUserName(), password, salt, null, null, null, roleList, command.getStatus());
                accountRepository.save(account);
                return mappingService.map(account, AccountRepresentation.class, false);
            }
        }
        return null;
    }

    @Override
    public AccountRepresentation edit(EditAccountCommand command) {
        Account account = accountRepository.getById(command.getId());
        account.fainWhenConcurrencyViolation(command.getVersion());
        accountRepository.update(account);
        return mappingService.map(account, AccountRepresentation.class, false);
    }

    @Override
    public void updateStatus(SharedCommand command) {
        Account account = accountRepository.getById(command.getId());
        if (null == account) {
            throw new NoFoundException("没有找到ID[" + command.getId() + "]的Account数据");
        }
        account.fainWhenConcurrencyViolation(command.getVersion());
        if (account.getStatus() == EnableStatus.DISABLE) {
            account.changeStatus(EnableStatus.ENABLE);
        } else {
            account.changeStatus(EnableStatus.DISABLE);
        }
        accountRepository.update(account);
    }

    @Override
    public void resetPassword(ResetPasswordCommand command) {
        Account account = accountRepository.getById(command.getId());
        if (null == account) {
            throw new NoFoundException("没有找到ID[" + command.getId() + "]的Account数据");
        }
        account.fainWhenConcurrencyViolation(command.getVersion());
        String password = PasswordHelper.encryptPassword(command.getPassword(), account.getSalt());
        account.changePassword(password);
        accountRepository.update(account);
    }

    @Override
    public void authorized(AuthorizeAccountCommand command) {
        List<Role> roleList = roleService.searchByIDs(command.getRoles());
        Account account = accountRepository.getById(command.getId());
        if (null == account) {
            throw new NoFoundException("没有找到ID[" + command.getId() + "]的Account数据");
        }
        account.fainWhenConcurrencyViolation(command.getVersion());
        account.changeRoles(roleList);
        accountRepository.update(account);
    }

    @Override
    public AccountRepresentation login(LoginCommand command) {
        AccountRepresentation account = this.searchByAccountName(command.getUserName());
        if (null == account) {
            throw new UnknownAccountException();
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                command.getUserName(),
                command.getPassword());
        subject.login(token);


        Account account_update = accountRepository.getById(account.getId());
        account_update.changeLastLoginIP(command.getLoginIP());
        account_update.changeLastLoginPlatform(command.getLoginPlatform());
        account_update.changeLastLoginDate(new Date());
        accountRepository.update(account_update);

        return mappingService.map(account_update, AccountRepresentation.class, false);
    }

    @Override
    public List<Account> searchByIDs(List<String> ids) {
        List<Account> accountList = new ArrayList<Account>();
        for (String item : ids) {
            Account account = accountRepository.getById(item);
            if (null == account) {
                throw new NoFoundException("没有找到ID[" + item + "]的Account数据");
            }
            accountList.add(account);
        }
        return accountList;
    }

    @Override
    public List<Account> searchByRoleIDs(List<String> ids) {
        List<Criterion> criterionList = new ArrayList<Criterion>();
        criterionList.add(Restrictions.in("role.id", ids));
        Map<String, String> alias = new HashMap<String, String>();
        alias.put("roles", "role");
        return accountRepository.list(criterionList, null, null, null, alias);
    }
}
