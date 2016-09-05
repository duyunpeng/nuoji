package chess.domain.service.advert.command;

import chess.core.enums.AdvertType;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by dyp on 2016/8/3.
 */
public class CreateAdvertCommand {


    private String id;
    private Integer version;
    private String createDate;

    @NotNull(message = "{advert.type.NotNull.messages}")
    private AdvertType type;        //广告类型
    @NotBlank(message = "{advert.content.NotBlank.messages}")
    private String content;         //内容(图片广告为图片路径)
    @NotBlank(message = "{advert.url.NotBlank.messages}")
    private String url;             //广告跳转路径

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public AdvertType getType() {
        return type;
    }

    public void setType(AdvertType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
