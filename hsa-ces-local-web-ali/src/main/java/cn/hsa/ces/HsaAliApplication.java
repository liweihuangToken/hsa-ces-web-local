package cn.hsa.ces;

import com.taobao.pandora.boot.PandoraBootstrap;
import com.ulisesbocchio.jasyptspringboot.environment.StandardEncryptableEnvironment;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;

@EnableCaching
@ImportResource("classpath:config/spring.xml")
@MapperScan(basePackages = {"cn.hsa.ces.**.dao"})
@SpringBootApplication(scanBasePackages = {"cn.hsa"})
public class HsaAliApplication {

    public static void main(String[] args) {
        // 启动 Pandora Boot 用于加载 Pandora 容器
        //使用hsf rpc则打开此注释
        PandoraBootstrap.run(args);

        new SpringApplicationBuilder().environment(new StandardEncryptableEnvironment()).sources(HsaAliApplication.class).run(args);

        // 标记服务启动完成,并设置线程 wait。防止用户业务代码运行完毕退出后，导致容器退出。
        PandoraBootstrap.markStartupAndWait();
    }

}
