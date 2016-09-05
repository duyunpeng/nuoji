package chess.domain.service.advert.representation;

import chess.core.enums.AdvertType;

import java.util.Date;

/**
 * Created by dyp on 2016/8/4.
 */
public class AdvertRepresentation {

    private String id;
    private Integer version;
    private Date createDate;

    private AdvertType type;        //广告类型
    private String content;         //内容(图片广告为图片路径)
    private String url;             //广告跳转路径

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
