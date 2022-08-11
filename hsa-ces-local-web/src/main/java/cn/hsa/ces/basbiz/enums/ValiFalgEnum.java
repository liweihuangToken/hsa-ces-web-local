package cn.hsa.ces.basbiz.enums;

/**
 * @Author: YourName
 * @Date: 2022/8/11
 */
public enum ValiFalgEnum {

    /**
     * 有效
     */
    VALI_FLAG_TRUE("1", "有效"),

    /**
     * 无效
     */
    VALI_FLAG_FLAS("0", "无效")
    ;

    private String code;

    private String name;

    ValiFalgEnum(String code, String name) {
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
