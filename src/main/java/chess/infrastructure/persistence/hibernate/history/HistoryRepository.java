package chess.infrastructure.persistence.hibernate.history;

import chess.domain.model.history.History;
import chess.domain.model.history.IHistoryRepository;
import chess.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import chess.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yjh on 2016/8/3.
 */
@Repository("historyRepository")
public class HistoryRepository extends AbstractHibernateGenericRepository<History, String> implements IHistoryRepository<History, String> {
}
