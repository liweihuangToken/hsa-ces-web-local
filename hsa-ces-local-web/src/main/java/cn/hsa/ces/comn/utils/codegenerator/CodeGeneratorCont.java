package cn.hsa.ces.comn.utils.codegenerator;

/**
 * @author Liweihuang
 */
public final class CodeGeneratorCont {

    private CodeGeneratorCont() { throw new IllegalStateException("CodeGeneratorCont class"); }

    public static final String AUTHOR = "caiws";
    public static final String DB_URL = "jdbc:mysql://10.16.0.148:3306/casemgt_db?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8";
    public static final String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "ylzinfo.com";

    public static final String PARENT_PACKAGE_PATH = "cn.hsa.ams";
    public static final String PROJECT_DB_PATH = "hsa-ams-local-db\\src\\main\\resources\\sql";
    public static final String PROJECT_SVC_PATH = "hsa-ams-local-svc\\src\\main\\java";

    public static final String DAO_TEMPLATE_PATH = "/templates/dao.java";
    public static final String ENTITY_TEMPLATE_PATH = "/templates/entity.java";
    public static final String SERVICE_TEMPLATE_PATH = "/templates/service.java";
    public static final String CONTROLLER_TEMPLATE_PATH = "/templates/controller.java";
    public static final String SERVICEIMPL_TEMPLATE_PATH = "/templates/serviceimpl.java";

    public static final String BO_TEMPLATE_PATH = "/templates/bo.java.vm";
    public static final String DTO_TEMPLATE_PATH = "/templates/dto.java.vm";
    public static final String BOIMPL_TEMPLATE_PATH = "/templates/boimpl.java.vm";
    public static final String MAPPER_TEMPLATE_PATH = "/templates/mapper.xml.vm";

    public static final String ADDDTO_TEMPLATE_PATH = "/templates/adddto.java.vm";
    public static final String UPDTDTO_TEMPLATE_PATH = "/templates/updatedto.java.vm";
    public static final String QUERYDTO_TEMPLATE_PATH = "/templates/querydto.java.vm";

}
