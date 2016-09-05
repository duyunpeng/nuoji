package chess.infrastructure.persistence.hibernate.sequence;

import chess.domain.model.sequence.ISequenceRepository;
import chess.domain.model.sequence.Sequence;
import chess.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by YJH on 2016/3/22.
 */
@Repository("sequenceRepository")
public class SequenceRepository extends AbstractHibernateGenericRepository<Sequence,String>
        implements ISequenceRepository<Sequence,String> {
}
