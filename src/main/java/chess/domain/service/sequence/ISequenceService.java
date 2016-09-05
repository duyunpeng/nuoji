package chess.domain.service.sequence;

/**
 * Created by YJH on 2016/3/22.
 */
public interface ISequenceService {
    long getNextSequence(int suffixValue);

    void initSequence();

    void reset();
}
