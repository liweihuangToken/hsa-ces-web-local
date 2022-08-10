package cn.hsa.ces.comn.utils;

import cn.hsa.ces.comn.cons.BizConstants;
import cn.hsa.ces.comn.cons.CustomDatePattern;
import cn.hsa.hsaf.auth.security.utils.SpringContextUtils;
import cn.hsa.hsaf.idgenerator.IdGenerator;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.text.CharSequenceUtil;

/**
 * 全局序列工具类
 *
 * @author liweihuang
 * @date 2022-04-26
 */
public class IdGeneratorUtils {

    private IdGeneratorUtils() {

    }

    /**
     * 根据seqName获取单个long型id
     *
     * @param seqName 序列名称
     * @return long
     */
    public static long getLongId(String seqName) {
        IdGenerator idGenerator = SpringContextUtils.getBean(IdGenerator.class.getSimpleName());
        return idGenerator.next(BizConstants.ID_SEQ_PREFIX + seqName.toLowerCase());
    }

    /**
     * 根据seqName获取单个String型id
     *
     * @param seqName 序列名称
     * @return String
     */
    public static String getStrId(String seqName) {
        long keyId = getLongId(seqName);
        return String.valueOf(keyId);
    }

    /**
     * 根据seqName获取单个String型主键
     *
     * @param seqName 序列名称  规则为时间戳(yyyyMMddHHmm)+流水号
     * @return String
     */
    public static String getStrPkId(String seqName) {
        // 流水号值保留8位
        long ridSeqNo = getLongId(seqName);
        String seqStr8 = String.format("%08d", ridSeqNo > 99999999 ? ridSeqNo % 100000000 : ridSeqNo);
        return LocalDateTimeUtil.format(LocalDateTimeUtil.now(), CustomDatePattern.PURE_DATETIME_MINUTE_PATTERN) + seqStr8;
    }

    /**
     * 获取固定位数的序列值，不足位数的左添0
     *
     * @param seqName
     * @param len
     * @return
     */
    public static String getFixedLenId(String seqName, int len) {
        String seqValue = String.format(CharSequenceUtil.format("%0{}d", len), getLongId(seqName));
        return seqValue.substring(seqValue.length() - len);
    }

    /**
     * 获取系统全局唯一序列号，rid = 行政区划id[6]+时间[yyyyMMddHHmmss][14]+[分组标识默认00][2]+全局唯一序列[8]
     *
     * @return
     */
    public static String getRid() {
        Long ridSeqNo = getLongId(BizConstants.RID_ADD);
        String snNoStr8 = String.format("%08d", ridSeqNo > 99999999 ? ridSeqNo % 100000000 : ridSeqNo);
        String dateStr14 = LocalDateTimeUtil.format(LocalDateTimeUtil.now(), CustomDatePattern.PURE_DATETIME_MINUTE_PATTERN);
        StringBuilder risSb =
                // 地区编码
                new StringBuilder(AppInfoConfigPropertiesUtils.getInstance().getAdmdvs())
                        // 14位时间
                        .append(dateStr14)
                        // 系统编码,国际局分配
                        .append(BizConstants.SYSTEAM_CODE)
                        // 全局唯一序列8位,不足8位左边补0
                        .append(snNoStr8);
        return risSb.toString();
    }

}
