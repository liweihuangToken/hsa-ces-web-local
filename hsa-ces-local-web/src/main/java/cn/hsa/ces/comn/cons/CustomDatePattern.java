package cn.hsa.ces.comn.cons;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.format.FastDateFormat;

/**
 * @author liweihuang
 */
public class CustomDatePattern extends DatePattern {

    public static final String PURE_DATETIME_MINUTE_PATTERN = "yyyyMMddHHmm";

    public static final FastDateFormat PURE_DATETIME_MINUTE_FORMAT = FastDateFormat.getInstance(PURE_DATETIME_MINUTE_PATTERN);
}
