package chess.domain.service.history.command;

import chess.core.common.BasicPaginationCommand;
import chess.core.enums.YesOrNoStatus;

import java.util.Date;

/**
 * Created by jm on 2016/8/3.
 */
public class ListHistoryCommand extends BasicPaginationCommand  {

    private String historyNo;       //期号
    private String lotteryNo;      //开奖号码 (三个1~9的数字, 用,分割)
    private Date lotteryDate;       //开奖时间
    private YesOrNoStatus isOpen;   //是否开奖

    public Date getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(Date lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public YesOrNoStatus getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(YesOrNoStatus isOpen) {
        this.isOpen = isOpen;
    }

    public String getHistoryNo() {
        return historyNo;
    }

    public void setHistoryNo(String historyNo) {
        this.historyNo = historyNo;
    }

    public String getLotteryNo() {
        return lotteryNo;
    }

    public void setLotteryNo(String lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

}
