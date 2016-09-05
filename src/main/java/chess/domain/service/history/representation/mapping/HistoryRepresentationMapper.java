package chess.domain.service.history.representation.mapping;

import chess.core.util.CoreDateUtils;
import chess.domain.model.history.History;
import chess.domain.service.history.representation.HistoryRepresentation;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by dyp on 2016/8/5.
 */
@Component
public class HistoryRepresentationMapper extends CustomMapper<History, HistoryRepresentation> {

    public void mapAtoB(History history, HistoryRepresentation representation, MappingContext context) {
        if (null != history.getLotteryDate()) {
            representation.setLotteryDate(CoreDateUtils.formatDate(history.getLotteryDate(), "yyyy-MM-dd HH:mm"));
        }
    }

}
