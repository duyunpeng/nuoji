package chess.domain.service.history;


import chess.domain.model.history.History;
import chess.domain.service.history.command.EditHistoryCommand;
import chess.domain.service.history.command.ListHistoryCommand;
import chess.domain.service.history.representation.HistoryRepresentation;
import chess.infrastructure.persistence.hibernate.generic.Pagination;

/**
 * Created by yjh on 2016/8/3.
 */
public interface IHistoryService {
    void initCreate();

    History getThisDay();

    void openLottery();

    Pagination<HistoryRepresentation> pagination(ListHistoryCommand command);

    Pagination<HistoryRepresentation> paginationAdmin(ListHistoryCommand command);

    History searchByID(String id);

    History edit(EditHistoryCommand command);

    History newHistory();

}
