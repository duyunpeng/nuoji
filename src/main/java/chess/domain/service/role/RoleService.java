package chess.domain.service.role;

import chess.core.mapping.IMappingService;
import chess.domain.service.role.command.CreateRoleCommand;
import chess.domain.service.role.command.EditRoleCommand;
import chess.domain.service.role.command.ListRoleCommand;
import chess.domain.service.role.representation.RoleRepresentation;
import chess.domain.service.shared.command.SharedCommand;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chess.core.enums.EnableStatus;
import chess.core.exception.ExistException;
import chess.core.exception.NoFoundException;
import chess.core.util.CoreStringUtils;
import chess.domain.model.permission.Permission;
import chess.domain.model.role.IRoleRepository;
import chess.domain.model.role.Role;
import chess.domain.service.permission.IPermissionService;
import chess.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
@Service("roleService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository<Role, String> roleRepository;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IMappingService mappingService;

    @Override
    public Pagination<RoleRepresentation> pagination(ListRoleCommand command) {
        command.verifyPage();
        command.verifyPageSize(30);
        List<Criterion> criterionList = new ArrayList<>();
        if (null != command.getIds() && command.getIds().size() > 0) {
            criterionList.add(Restrictions.in("id", command.getIds()));
        }
        if (!CoreStringUtils.isEmpty(command.getName())) {
            criterionList.add(Restrictions.like("name", command.getName(), MatchMode.ANYWHERE));
        }
        if (null != command.getStatus() && command.getStatus() != EnableStatus.ALL) {
            criterionList.add(Restrictions.eq("status", command.getStatus()));
        }
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("createDate"));


        Pagination<Role> pagination = roleRepository.pagination(command.getPage(), command.getPageSize(), criterionList, orderList);
        List<RoleRepresentation> data = mappingService.mapAsList(pagination.getData(), RoleRepresentation.class);
        return new Pagination<>(data, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }

    @Override
    public List<Role> list(ListRoleCommand command) {
        List<Criterion> criterionList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.desc("createDate"));
        return roleRepository.list(criterionList, orderList);
    }

    @Override
    public RoleRepresentation searchByID(String id) {
        Role role = roleRepository.getById(id);
        if (null == role) {
            throw new NoFoundException("没有找到ID[" + id + "]的Role数据");
        }
        return mappingService.map(role, RoleRepresentation.class, false);
    }

    @Override
    public RoleRepresentation searchByName(String name) {
        Role role = roleRepository.searchByName(name);
        return mappingService.map(role, RoleRepresentation.class, false);
    }

    @Override
    public Role create(CreateRoleCommand command) {
        List<Permission> permissionList = permissionService.searchByIDs(command.getPermissions());
        Role role = new Role(command.getName(), command.getDescription(), permissionList, command.getStatus());
        roleRepository.save(role);
        return role;
    }

    @Override
    public RoleRepresentation edit(EditRoleCommand command) {
        Role role = roleRepository.getById(command.getId());
        role.fainWhenConcurrencyViolation(command.getVersion());
        if (!role.getName().equals(command.getName())) {
            if (null != this.searchByName(command.getName())) {
                throw new ExistException("name[" + command.getName() + "]的Role数据已存在");
            }
        }
        List<Permission> permissionList = permissionService.searchByIDs(command.getPermissions());
        role.changeName(command.getName());
        role.changeDescription(command.getDescription());
        role.changePermissions(permissionList);
        roleRepository.update(role);
        return mappingService.map(role, RoleRepresentation.class, false);
    }

    @Override
    public void updateStatus(SharedCommand command) {
        Role role = roleRepository.getById(command.getId());
        role.fainWhenConcurrencyViolation(command.getVersion());
        if (role.getStatus() == EnableStatus.DISABLE) {
            role.changeStatus(EnableStatus.ENABLE);
        } else {
            role.changeStatus(EnableStatus.DISABLE);
        }
        roleRepository.update(role);
    }

    @Override
    public List<Role> searchByIDs(List<String> ids) {
        List<Role> roleList = null;
        if (null != ids && ids.size() > 0) {
            roleList = new ArrayList<>();
            for (String item : ids) {
                Role role = roleRepository.getById(item);
                roleList.add(role);
            }
        }
        return roleList;
    }
}
