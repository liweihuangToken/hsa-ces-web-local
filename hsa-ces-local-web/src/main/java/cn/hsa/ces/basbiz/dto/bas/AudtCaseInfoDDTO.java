package cn.hsa.ces.basbiz.dto.bas;

import cn.hsa.ces.basbiz.dto.BasDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 稽核案件信息表传输对象
 * </p>
 *
 * @author liweihuang
 * @since 2021-07-23
 */
@ApiModel(value = "稽核案件信息表传输对象" , description = "稽核案件信息表传输对象" )
@Data
public class AudtCaseInfoDDTO extends BasDTO implements Serializable{

    private static final long serialVersionUID= 1L;

    @ApiModelProperty(value = "稽核案件信息ID")
    private String audtCaseInfoId;

    @ApiModelProperty(value = "稽核节点编码")
    private String audtNodeCode;

    @ApiModelProperty(value = "处理人姓名")
    private String procerName;

    @ApiModelProperty(value = "巡查案件编号")
    private String insptCaseCode;

    @ApiModelProperty(value = "稽核案件来源")
    private String insptCaseSouc;

    @ApiModelProperty(value = "稽核对象类型")
    private String audtObjType;

    @ApiModelProperty(value = "对象编号")
    private String objNo;

    @ApiModelProperty(value = "对象名称")
    private String objName;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime begntime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime endtime;

    @ApiModelProperty(value = "阶段处理人姓名")
    private String stgProcerName;

    @ApiModelProperty(value = "服务事项实例ID")
    private String servMattInstId;

    @ApiModelProperty(value = "完成标志")
    private String cpltFlag;

    @ApiModelProperty(value = "当前环节名称")
    private String crtNodeName;

    @ApiModelProperty(value = "承办单位名称")
    private String undtkeUnitName;

    @ApiModelProperty(value = "承办单位ID")
    private String undtkeUnitId;

    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    @ApiModelProperty(value = "稽核对象医保区划")
    private String audtObjAdmdvs;

}
