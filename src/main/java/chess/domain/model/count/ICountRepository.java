package chess.domain.model.count;

import chess.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by yjh on 2016/8/5.
 */
public interface ICountRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
