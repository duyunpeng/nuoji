package chess.domain.service.permission;


import chess.domain.model.permission.Permission;
import chess.domain.service.permission.command.CreatePermissionCommand;
import chess.domain.service.permission.command.EditPermissionCommand;
import chess.domain.service.permission.command.ListPermissionCommand;
import chess.domain.service.shared.command.SharedCommand;
import chess.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IPermissionService {

    Pagination<Permission> pagination(ListPermissionCommand command);

    List<Permission> list(ListPermissionCommand command);

    List<Permission> searchByIDs(List<String> ids);

    Permission searchByID(String id);

    Permission searchByName(String name);

    Permission create(CreatePermissionCommand command);

    Permission edit(EditPermissionCommand command);

    void updateStatus(SharedCommand command);
}
