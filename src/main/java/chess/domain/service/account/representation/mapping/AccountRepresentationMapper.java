package chess.domain.service.account.representation.mapping;


import chess.core.mapping.IMappingService;
import chess.core.util.CoreDateUtils;
import chess.domain.model.account.Account;
import chess.domain.service.account.representation.AccountRepresentation;
import chess.domain.service.role.representation.RoleRepresentation;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YJH on 2016/3/30 0030.
 */
@Component
public class AccountRepresentationMapper extends CustomMapper<Account, AccountRepresentation> {

    @Autowired
    private IMappingService mappingService;

    public void mapAtoB(Account account, AccountRepresentation representation, MappingContext context) {
        if (null != account.getRoles()) {
            List<RoleRepresentation> data = mappingService.mapAsList(account.getRoles(), RoleRepresentation.class);
            representation.setRoles(data);
        }
    }

}
