package cn.hsa.ces.comn.config;

import cn.hsa.ces.comn.cons.BizConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 根据前缀定义及宽松绑定原则读取系统基础配置
 *
 * @author liweihuang
 */
@Data
@Component(value = "AppInfoConfigProperties")
@ConfigurationProperties(prefix = BizConstants.SYSTEM_ABBR)
public class AppInfoConfigProperties {

    private String admdvs;

    private List<String> csrfurl;
}
