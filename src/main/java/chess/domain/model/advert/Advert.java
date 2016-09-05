package chess.domain.model.advert;

import chess.core.enums.AdvertType;
import chess.core.id.ConcurrencySafeEntity;

/**
 * Created by pengyi on 16-8-3.
 */
public class Advert extends ConcurrencySafeEntity {

    private AdvertType type;        //广告类型
    private String content;         //内容(图片广告为图片路径)
    private String url;             //广告跳转路径

    public Advert() {
    }

    public Advert(AdvertType type, String content, String url) {
        this.type = type;
        this.content = content;
        this.url = url;
    }

    public AdvertType getType() {
        return type;
    }

    private void setType(AdvertType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public void changeUrl(String url) {
        this.url = url;
    }

    public void changeType(AdvertType type) {
        this.type = type;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
