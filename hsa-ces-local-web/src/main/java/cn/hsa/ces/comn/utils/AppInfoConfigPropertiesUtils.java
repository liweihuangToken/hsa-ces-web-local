package cn.hsa.ces.comn.utils;

import cn.hsa.ces.comn.config.AppInfoConfigProperties;
import cn.hsa.hsaf.auth.security.utils.SpringContextUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 系统基础配置参数工具类
 *
 * @author liweihuang
 */
@Data
@Slf4j
public class AppInfoConfigPropertiesUtils {

    private String admdvs;

    private List<String> csrfurl;

    private AppInfoConfigPropertiesUtils() {
        // 获取应用配置参数BEAN并初始化类属性
        AppInfoConfigProperties appInfoConfigProperties = SpringContextUtils.getBean(AppInfoConfigProperties.class.getSimpleName());
        this.admdvs = appInfoConfigProperties.getAdmdvs();
        this.csrfurl = appInfoConfigProperties.getCsrfurl();
    }

    private static AppInfoConfigPropertiesUtils appInfoConfigPropertiesUtils;

    /**
     * 获取应用配置参数实例，避免多线程情况下失效使用同步锁
     *
     * @return
     */
    public static synchronized AppInfoConfigPropertiesUtils getInstance() {
        if (null == appInfoConfigPropertiesUtils) {
            appInfoConfigPropertiesUtils = new AppInfoConfigPropertiesUtils();
        }
        return appInfoConfigPropertiesUtils;
    }

}
