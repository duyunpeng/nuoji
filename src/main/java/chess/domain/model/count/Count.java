package chess.domain.model.count;

import chess.core.id.ConcurrencySafeEntity;

/**
 * Created by yjh on 2016/8/5.
 */
public class Count extends ConcurrencySafeEntity {

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Count() {
        super();
    }

    public Count(long count) {
        this.count = count;
    }
}
