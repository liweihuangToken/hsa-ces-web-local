package cn.hsa.ces.basbiz.enums;

/**
 * @author Liweihuang
 */

public enum DelFlagEnum {

    /**
     * 未删除
     */
    DEL_FLAG_NO("0", "未删除"),

    /**
     * 已删除
     */
    DEL_FLAG_YES("1", "已删除"),

    /**
     * 删除中
     */
    DEL_FLAG_SCZ("2","删除中")
    ;

    private String code;

    private String name;

    DelFlagEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
