package cn.hsa.ces.comn.utils.codegenerator;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

/**
 * 代码生成配置枚举
 *
 * @author liweihuang
 */
public enum FileOutConfigEnum {
    QUERYDTO("dto", CodeGeneratorCont.QUERYDTO_TEMPLATE_PATH, "QueryDTO" + StringPool.DOT_JAVA, "dto\\query"),
    UPDTDTO("dto", CodeGeneratorCont.UPDTDTO_TEMPLATE_PATH, "UpdateDTO" + StringPool.DOT_JAVA, "dto\\updt"),
    ADDDTO("dto", CodeGeneratorCont.ADDDTO_TEMPLATE_PATH, "AddDTO" + StringPool.DOT_JAVA, "dto\\add"),
    DTO("dto", CodeGeneratorCont.DTO_TEMPLATE_PATH, "DTO" + StringPool.DOT_JAVA, "dto\\bas"),
    BO("bo", CodeGeneratorCont.BO_TEMPLATE_PATH, "BO" + StringPool.DOT_JAVA, "bo"),
    BOIMPL("boImpl", CodeGeneratorCont.BOIMPL_TEMPLATE_PATH, "BOImpl" + StringPool.DOT_JAVA, "bo\\impl"),
    XML("xml", CodeGeneratorCont.MAPPER_TEMPLATE_PATH, "Mapper" + StringPool.DOT_XML, "sql"),
    ;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 模板路径
     */
    private String templatePath;

    /**
     * 文件后缀名
     */
    private String suffix;

    /**
     * 生成包名
     */
    private String path;

    FileOutConfigEnum(String fileType, String templatePath, String suffix, String path) {
        this.fileType = fileType;
        this.templatePath = templatePath;
        this.suffix = suffix;
        this.path = path;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
