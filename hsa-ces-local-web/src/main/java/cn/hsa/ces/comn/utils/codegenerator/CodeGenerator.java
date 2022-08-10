package cn.hsa.ces.comn.utils.codegenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Liweihuang
 */
public class CodeGenerator {

    public static void main(String[] args) throws IOException {
        // 代码生成器声明
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = getGlobalConfig();
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = getDataSourceConfig();
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = getPackageConfig();
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = getStrategyConfig(pc);
        mpg.setStrategy(strategy);

        // 自定义配置
        InjectionConfig cfg = getInjectionConfig(mpg);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity(CodeGeneratorCont.ENTITY_TEMPLATE_PATH);
        templateConfig.setController(null);
        templateConfig.setService(CodeGeneratorCont.SERVICE_TEMPLATE_PATH);
        templateConfig.setServiceImpl(CodeGeneratorCont.SERVICEIMPL_TEMPLATE_PATH);
        templateConfig.setMapper(CodeGeneratorCont.DAO_TEMPLATE_PATH);
        templateConfig.setXml(null);

        mpg.setTemplate(templateConfig);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    /**
     * 全局配置
     * @return
     * @throws IOException
     */
    public static GlobalConfig getGlobalConfig() throws IOException {
        GlobalConfig gc = new GlobalConfig();
        File file = new File("");
        String filePath = file.getAbsolutePath() + File.separator + CodeGeneratorCont.PROJECT_SVC_PATH;
        gc.setOutputDir(filePath);
        gc.setAuthor(CodeGeneratorCont.AUTHOR);
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        // 设置各个文件名后缀
        gc.setEntityName("%sDO");
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDAO");
        return gc;
    }

    /**
     * 数据源配置
     *
     * @return
     */
    public static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(CodeGeneratorCont.DB_URL);
        dsc.setDriverName(CodeGeneratorCont.DB_DRIVER_NAME);
        dsc.setUsername(CodeGeneratorCont.DB_USERNAME);
        dsc.setPassword(CodeGeneratorCont.DB_PASSWORD);
        return dsc;
    }

    /**
     * 包信息配置
     *
     * @return
     */
    public static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent(CodeGeneratorCont.PARENT_PACKAGE_PATH);

        // 这个各个文件夹名
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        return pc;
    }

    public static StrategyConfig getStrategyConfig(PackageConfig pc) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名"));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityColumnConstant(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        return strategy;
    }

    /**
     * 自定义文件列表
     * @param mpg
     * @return
     */
    public static InjectionConfig getInjectionConfig(AutoGenerator mpg){
        // 自定义配置
        PackageConfig pc = mpg.getPackageInfo();
        GlobalConfig gc = mpg.getGlobalConfig();
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {}
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        for (FileOutConfigEnum fileOutConfigEnum : FileOutConfigEnum.values()) {
            FileOutConfig fileOutConfig = new FileOutConfig(fileOutConfigEnum.getTemplatePath()) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    String entityName = tableInfo.getEntityName();
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    if(fileOutConfigEnum.getFileType().equalsIgnoreCase("XML")){
                        return CodeGeneratorCont.PROJECT_DB_PATH
                                + "\\" + pc.getModuleName()
                                + "\\" + entityName.substring(0, entityName.length() - 2)
                                + fileOutConfigEnum.getSuffix();
                    }else{
                        return gc.getOutputDir()
                                + "\\" + pc.getParent().replace(".", "\\")
                                + "\\" + fileOutConfigEnum.getPath()
                                + "\\" + entityName.substring(0, entityName.length() - 2)
                                + fileOutConfigEnum.getSuffix();
                    }

                }
            };
            focList.add(fileOutConfig);
        }
        cfg.setFileOutConfigList(focList);
        return cfg;
    }




    /**
     * 读取控制台内容
     *
     * @param tip
     * @return
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}

