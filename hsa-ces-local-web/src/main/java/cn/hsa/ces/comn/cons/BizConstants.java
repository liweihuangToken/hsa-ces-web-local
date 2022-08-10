package cn.hsa.ces.comn.cons;

/**
 * 业务流水号(主键) Redis KeyName
 *
 * @author liweihuang
 */
public class BizConstants {

    /**
     * 工具类里面不能有public的构造函数，需要构建一个private 的构造函数
     */
    private BizConstants() {

    }

    /**
     * 系统分组标识代码
     */
    public static final String SYSTEAM_CODE = "08";

    /**
     * 系统名称简写
     */
    public static final String SYSTEM_ABBR = "ces";

    /**
     * 默认序列key
     */
    public static final String ID_SEQ_PREFIX = SYSTEM_ABBR + ":seq:";

    /**
     * Rid
     */
    public static final String RID_ADD = "rid:add";

}
