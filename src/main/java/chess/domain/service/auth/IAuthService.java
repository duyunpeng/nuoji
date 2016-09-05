package chess.domain.service.auth;


import chess.domain.model.permission.Permission;
import chess.domain.service.account.representation.AccountRepresentation;
import chess.domain.service.auth.command.LoginCommand;

import java.util.List;

/**
 * Created by YJH on 2016/4/5.
 */
public interface IAuthService {
    AccountRepresentation searchByAccountName(String userName);

    List<Permission> findAllPermission();

    AccountRepresentation login(LoginCommand command);
}
