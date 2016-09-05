package chess.domain.service.role;

import chess.domain.model.role.Role;
import chess.domain.service.role.command.CreateRoleCommand;
import chess.domain.service.role.command.EditRoleCommand;
import chess.domain.service.role.command.ListRoleCommand;
import chess.domain.service.role.representation.RoleRepresentation;
import chess.domain.service.shared.command.SharedCommand;
import chess.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IRoleService {

    Pagination<RoleRepresentation> pagination(ListRoleCommand command);

    List<Role> list(ListRoleCommand command);

    RoleRepresentation searchByID(String id);

    RoleRepresentation searchByName(String name);

    Role create(CreateRoleCommand command);

    RoleRepresentation edit(EditRoleCommand command);

    void updateStatus(SharedCommand command);

    List<Role> searchByIDs(List<String> ids);
}
