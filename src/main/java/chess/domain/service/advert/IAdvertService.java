package chess.domain.service.advert;

import chess.domain.model.advert.Advert;
import chess.domain.service.advert.command.CreateAdvertCommand;
import chess.domain.service.advert.command.EditAdvertCommand;
import chess.domain.service.advert.command.ListAdvertCommand;
import chess.domain.service.advert.representation.AdvertRepresentation;
import chess.infrastructure.persistence.hibernate.generic.Pagination;

/**
 * Created by dyp on 2016/8/3.
 */
public interface IAdvertService {

    Pagination<AdvertRepresentation> pagination(ListAdvertCommand command);

    AdvertRepresentation create(CreateAdvertCommand command);

    AdvertRepresentation searchByID(String id);

    AdvertRepresentation searchByUrl(String url);

    Advert edit(EditAdvertCommand command);

    void delete(String id);

}
