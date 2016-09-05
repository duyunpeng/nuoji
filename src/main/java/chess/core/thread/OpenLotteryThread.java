package chess.core.thread;

import chess.core.util.CoreDateUtils;
import chess.domain.service.history.IHistoryService;

import java.util.Date;

/**
 * Created by yjh on 2016/8/4.
 */
public class OpenLotteryThread extends Thread {

    private IHistoryService historyService;

    public IHistoryService getHistoryService() {
        return historyService;
    }

    public void setHistoryService(IHistoryService historyService) {
        this.historyService = historyService;
    }

    @Override
    public void run() {
        historyService.initCreate();
        while (true) {
            try {
                Date newDate = new Date();
                System.out.println(CoreDateUtils.formatDate(newDate, "yyyy-MM-dd HH:mm"));
                int minutes = newDate.getMinutes();
                int seconds = newDate.getSeconds();
                if (minutes % 5 == 0) {
                    historyService.openLottery();
                    System.out.println(CoreDateUtils.formatDate(newDate, "yyyy-MM-dd HH:mm:ss") + "休眠五分钟");
                    Thread.sleep(300000 - (seconds) * 1000);//休眠5分钟
                } else {
                    int surplus = (60 - minutes) % 5;
                    int sleepTime = surplus * 60000;//休眠时间
                    sleepTime -= (seconds) * 1000;
                    System.out.println(CoreDateUtils.formatDate(newDate, "yyyy-MM-dd HH:mm:ss") + "休眠" + surplus + "分钟");
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                run();
            }
        }
    }

}
