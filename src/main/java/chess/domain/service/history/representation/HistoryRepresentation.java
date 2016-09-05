package chess.domain.service.history.representation;

import chess.core.enums.YesOrNoStatus;

import java.util.Date;

/**
 * Created by dyp on 2016/8/5.
 */
public class HistoryRepresentation {
    private String id;
    private Integer version;
    private Date createDate;

    private String historyNo;       //期号
    private String lotteryNo;      //开奖号码 (三个1~9的数字, 用,分割)
    private String lotteryDate;       //开奖时间
    private YesOrNoStatus isOpen;   //是否开奖

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getHistoryNo() {
        return historyNo;
    }

    public void setHistoryNo(String historyNo) {
        this.historyNo = historyNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YesOrNoStatus getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(YesOrNoStatus isOpen) {
        this.isOpen = isOpen;
    }

    public String getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(String lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public String getLotteryNo() {
        return lotteryNo;
    }

    public void setLotteryNo(String lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
