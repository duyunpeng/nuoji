package chess.core.enums;

/**
 * Created by pengyi on 16-8-3.
 */
public enum AdvertType {

    ALL("全部", 0, Boolean.TRUE),
    PICTURE("图片广告", 1, Boolean.FALSE),
    TEXT("文字广告", 2, Boolean.FALSE);

    AdvertType(String name, int value, Boolean onlyQuery) {
        this.name = name;
        this.value = value;
        this.onlyQuery = onlyQuery;
    }

    private String name;

    private int value;

    private Boolean onlyQuery;                  // 仅用于页面查询和业务逻辑无关

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public Boolean isOnlyQuery() {
        return onlyQuery;
    }
}
