package cn.hsa.ces.basbiz.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 稽核案件信息表实体对象
 * </p>
 *
 * @author liweihuang
 * @since 2021-07-23
 */
@ApiModel(value = "稽核案件信息表实体对象" , description = "稽核案件信息表实体对象" )
@TableName(value = "AUDT_CASE_INFO_D")
@Data
public class AudtCaseInfoDDO implements Serializable{

    private static final long serialVersionUID= 1L;

    @ApiModelProperty(value = "稽核案件信息ID")
    @TableId(value = "AUDT_CASE_INFO_ID", type = IdType.INPUT)
    private String audtCaseInfoId;

    @ApiModelProperty(value = "稽核节点编码")
    @TableField(value = "AUDT_NODE_CODE")
    private String audtNodeCode;

    @ApiModelProperty(value = "处理人姓名")
    @TableField(value = "PROCER_NAME")
    private String procerName;

    @ApiModelProperty(value = "巡查案件编号")
    @TableField(value = "INSPT_CASE_CODE")
    private String insptCaseCode;

    @ApiModelProperty(value = "稽核案件来源")
    @TableField(value = "INSPT_CASE_SOUC")
    private String insptCaseSouc;

    @ApiModelProperty(value = "稽核对象类型")
    @TableField(value = "AUDT_OBJ_TYPE")
    private String audtObjType;

    @ApiModelProperty(value = "对象编号")
    @TableField(value = "OBJ_NO")
    private String objNo;

    @ApiModelProperty(value = "对象名称")
    @TableField(value = "OBJ_NAME")
    private String objName;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "BEGNTIME")
    private LocalDateTime begntime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "ENDTIME")
    private LocalDateTime endtime;

    @ApiModelProperty(value = "阶段处理人姓名")
    @TableField(value = "STG_PROCER_NAME")
    private String stgProcerName;

    @ApiModelProperty(value = "服务事项实例ID")
    @TableField(value = "SERV_MATT_INST_ID")
    private String servMattInstId;

    @ApiModelProperty(value = "完成标志")
    @TableField(value = "CPLT_FLAG")
    private String cpltFlag;

    @ApiModelProperty(value = "当前环节名称")
    @TableField(value = "CRT_NODE_NAME")
    private String crtNodeName;

    @ApiModelProperty(value = "承办单位名称")
    @TableField(value = "UNDTKE_UNIT_NAME")
    private String undtkeUnitName;

    @ApiModelProperty(value = "承办单位ID")
    @TableField(value = "UNDTKE_UNIT_ID")
    private String undtkeUnitId;

    @ApiModelProperty(value = "删除标志")
    @TableField(value = "DEL_FLAG", fill = FieldFill.INSERT)
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value = "稽核对象医保区划")
    @TableField(value = "AUDT_OBJ_ADMDVS")
    private String audtObjAdmdvs;

    @ApiModelProperty(value = "数据唯一记录号")
    @TableField(value = "RID", fill = FieldFill.INSERT)
    private String rid;

    @ApiModelProperty(value = "创建人ID")
    @TableField(value = "CRTER_ID", fill = FieldFill.INSERT)
    private String crterId;

    @ApiModelProperty(value = "创建人姓名")
    @TableField(value = "CRTER_NAME", fill = FieldFill.INSERT)
    private String crterName;

    @ApiModelProperty(value = "数据创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "CRTE_TIME", fill = FieldFill.INSERT)
    private LocalDateTime crteTime;

    @ApiModelProperty(value = "经办人ID")
    @TableField(value = "OPTER_ID", fill = FieldFill.INSERT_UPDATE)
    private String opterId;

    @ApiModelProperty(value = "经办人姓名")
    @TableField(value = "OPTER_NAME", fill = FieldFill.INSERT_UPDATE)
    private String opterName;

    @ApiModelProperty(value = "经办机构编号")
    @TableField(value = "OPTINS_NO", fill = FieldFill.INSERT_UPDATE)
    private String optinsNo;

    @ApiModelProperty(value = "经办机构名称")
    @TableField(value = "OPTINS_NAME", fill = FieldFill.INSERT_UPDATE)
    private String optinsName;

    @ApiModelProperty(value = "经办时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "OPT_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime optTime;

    @ApiModelProperty(value = "数据更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    @TableField(value = "UPDT_TIME", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updtTime;

    @ApiModelProperty(value = "医保区划编码")
    @TableField(value = "ADMDVS", fill = FieldFill.INSERT_UPDATE)
    private String admdvs;

}
