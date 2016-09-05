package chess.domain.model.history;

import chess.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by yjh on 2016/8/3.
 */
public interface IHistoryRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
