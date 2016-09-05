package chess.infrastructure.persistence.hibernate.advert;

import chess.domain.model.advert.Advert;
import chess.domain.model.advert.IAdvertRepository;
import chess.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by yjh on 2016/8/3.
 */
@Repository("advertRepository")
public class AdvertRepository extends AbstractHibernateGenericRepository<Advert, String> implements IAdvertRepository<Advert, String> {

    @Override
    public Advert searchByUrl(String url) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        criteria.add(Restrictions.eq("url", url));
        return (Advert) criteria.uniqueResult();
    }
}
