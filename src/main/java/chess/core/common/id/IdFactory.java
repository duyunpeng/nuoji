package chess.core.common.id;


import chess.core.util.CoreDateUtils;
import chess.core.util.CoreStringUtils;
import chess.domain.service.sequence.ISequenceService;

import java.util.Date;

/**
 * Created by YJH on 2016/3/22.
 */
public class IdFactory {

    private ISequenceService sequenceService;

    private String prefix;

    private int suffixValue;

    private Date nextDay;

    private String currentDay;

    public IdFactory() {
        setNextDay();
    }

    private void setNextDay() {
        Date now = new Date();
        this.currentDay = CoreDateUtils.formatDate(now, "yyyyMMdd");
        this.nextDay = CoreDateUtils.addDay(now, 1);
    }

    public void init() {
        sequenceService.initSequence();
    }

    public synchronized String getNextId() {

        if (CoreDateUtils.isSameDay(new Date(), nextDay)) {
            setNextDay();
            sequenceService.reset();
        }

        StringBuilder sb = new StringBuilder(prefix);
        sb.append(currentDay)
                .append(CoreStringUtils.fillZero(sequenceService.getNextSequence(suffixValue), 3));

        return sb.toString();
    }

    public void setSequenceAppService(ISequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffixValue(int suffixValue) {
        this.suffixValue = suffixValue;
    }
}
