package chess.domain.service.permission.representation.mapping;

import chess.domain.model.permission.Permission;
import chess.domain.service.permission.representation.PermissionRepresentation;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by YJH on 2016/3/30 0030.
 */
@Component
public class PermissionRepresentationMapper extends CustomMapper<Permission, PermissionRepresentation> {

}
