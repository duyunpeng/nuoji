package chess.domain.service.count;

import chess.domain.model.count.Count;
import chess.domain.model.count.ICountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yjh on 2016/8/5.
 */
@Service("countService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class CountService implements ICountService {

    @Autowired
    private ICountRepository<Count, String> countRepository;

    @Override
    public long add() {
        List<Count> countList = countRepository.findAll();
        if (countList.size() > 0) {
            Count count = countList.get(0);
            count.setCount(count.getCount() + 1);
            countRepository.update(count);
            return count.getCount();
        } else {
            Count count = new Count(1);
            countRepository.save(count);
            return count.getCount();
        }
    }
}
