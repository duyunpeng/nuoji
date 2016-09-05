package chess.domain.service.account;

import chess.domain.model.account.Account;
import chess.domain.service.account.command.*;
import chess.domain.service.account.representation.AccountRepresentation;
import chess.domain.service.auth.command.LoginCommand;
import chess.domain.service.shared.command.SharedCommand;
import chess.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by YJH on 2016/3/30.
 */
public interface IAccountService {

    Pagination<AccountRepresentation> pagination(ListAccountCommand command);

    List<AccountRepresentation> list(ListAccountCommand command);

    AccountRepresentation searchByID(String id);

    AccountRepresentation searchByAccountName(String userName);

    AccountRepresentation create(CreateAccountCommand command);

    AccountRepresentation edit(EditAccountCommand command);

    void updateStatus(SharedCommand command);

    void resetPassword(ResetPasswordCommand command);

    void authorized(AuthorizeAccountCommand command);

    AccountRepresentation login(LoginCommand command);

    List<Account> searchByIDs(List<String> ids);

    List<Account> searchByRoleIDs(List<String> ids);

}
