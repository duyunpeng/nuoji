package chess.domain.model.history;

import chess.core.enums.YesOrNoStatus;
import chess.core.id.ConcurrencySafeEntity;

import java.util.Date;

/**
 * Created by pengyi on 16-8-3.
 */
public class History extends ConcurrencySafeEntity {

    private String historyNo;       //期号
    private String lotteryNo;      //开奖号码 (三个1~9的数字, 用,分割)
    private Date lotteryDate;       //开奖时间
    private YesOrNoStatus isOpen;   //是否开奖

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

    public History() {
    }

    public History(String historyNo, String lotteryNo, Date lotteryDate,YesOrNoStatus isOpen) {
        this.historyNo = historyNo;
        this.lotteryNo = lotteryNo;
        this.lotteryDate = lotteryDate;
        this.isOpen = isOpen;
        this.setCreateDate(new Date());
    }

    public void changeLotteryNo(String lotteryNo) {
      this.lotteryNo = lotteryNo;
    }
}
