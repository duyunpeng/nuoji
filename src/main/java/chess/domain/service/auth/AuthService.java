package chess.domain.service.auth;

import chess.core.enums.EnableStatus;
import chess.domain.model.account.Account;
import chess.domain.model.permission.Permission;
import chess.domain.service.account.IAccountService;
import chess.domain.service.account.representation.AccountRepresentation;
import chess.domain.service.auth.command.LoginCommand;
import chess.domain.service.permission.IPermissionService;
import chess.domain.service.permission.command.ListPermissionCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YJH on 2016/4/5.
 */
@Service("authService")
public class AuthService implements IAuthService {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public AccountRepresentation searchByAccountName(String userName) {
        return accountService.searchByAccountName(userName);
    }

    @Override
    public List<Permission> findAllPermission() {
        ListPermissionCommand command = new ListPermissionCommand();
        command.setStatus(EnableStatus.ENABLE);
        return permissionService.list(command);
    }

    @Override
    public AccountRepresentation login(LoginCommand command) {
        return accountService.login(command);
    }
}
