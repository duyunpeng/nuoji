package chess.domain.service.advert.representation.mapping;

import chess.domain.model.advert.Advert;
import chess.domain.service.advert.representation.AdvertRepresentation;
import ma.glasnost.orika.CustomMapper;
import org.springframework.stereotype.Component;

/**
 * Created by dyp on 2016/8/4.
 */
@Component
public class AdvertRepresentationMapper extends CustomMapper<Advert, AdvertRepresentation> {

}
