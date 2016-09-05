package chess.domain.model.advert;

import chess.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by yjh on 2016/8/3.
 */
public interface IAdvertRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
    Advert searchByUrl(String url);
}
