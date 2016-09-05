package chess.domain.service.history.command;

import chess.core.common.BasicPaginationCommand;
import chess.core.enums.YesOrNoStatus;
import chess.domain.service.shared.command.SharedCommand;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by jm on 2016/8/4.
 */
public class EditHistoryCommand extends SharedCommand {

    @NotBlank(message = "{history.lotteryNo.NotBlank.messages}")
    private String lotteryNo;      //开奖号码 (三个1~9的数字, 用,分割)


    public String getLotteryNo() {
        return lotteryNo;
    }

    public void setLotteryNo(String lotteryNo) {
        this.lotteryNo = lotteryNo;
    }

}
