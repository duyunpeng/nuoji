package chess.infrastructure.persistence.hibernate.count;

import chess.domain.model.count.Count;
import chess.domain.model.count.ICountRepository;
import chess.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yjh on 2016/8/5.
 */
@Repository("countRepository")
public class CountRepository extends AbstractHibernateGenericRepository<Count, String> implements ICountRepository<Count, String> {
}
