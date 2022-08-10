package cn.hsa.ces;

import com.tencent.tsf.monitor.annotation.EnableTsfMonitor;
import com.tencent.tsf.sleuth.annotation.EnableTsfSleuth;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.tsf.route.annotation.EnableTsfRoute;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.tsf.auth.annotation.EnableTsfAuth;
import org.springframework.tsf.ratelimit.annotation.EnableTsfRateLimit;


/**
 * @author 10459
 */
@EnableDiscoveryClient // 使用服务注册发现时请启用
@EnableFeignClients(basePackages = {"cn.hsa.cep.*"}) // 使用Feign微服务调用时请启用
@EnableConfigurationProperties // 使用分布式配置时请启用
@EnableTsfAuth    //服务鉴权
@EnableTsfRoute
@EnableTsfRateLimit   //服务限流
@EnableTsfSleuth
@EnableTsfMonitor
@EnableCaching
@EnableScheduling  //定时任务
@ImportResource("classpath*:config/spring.xml")
@MapperScan(basePackages = {"cn.hsa.ces.**.dao"})
@SpringBootApplication(scanBasePackages = {"cn.hsa"})
public class HsaTencentApplication {
    public static void main(String[] args) {
        SpringApplication.run(HsaTencentApplication.class, args);
    }

}
