package chess.domain.service.advert.command;

import chess.core.common.BasicPaginationCommand;
import chess.core.enums.AdvertType;

/**
 * Created by dyp on 2016/8/3.
 */
public class ListAdvertCommand extends BasicPaginationCommand {

    private AdvertType type;        //广告类型
    private String content;         //内容(图片广告为图片路径)

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }
}
