package cn.hsa.ces.basbiz.dto.query;

import cn.hsa.ces.basbiz.dto.bas.AudtCaseInfoDDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 稽核案件信息表查询传输对象
 * </p>
 *
 * @author liweihuang
 * @since 2021-07-23
 */
@ApiModel(value = "稽核案件信息表查询传输对象" , description = "稽核案件信息表查询传输对象" )
@Data
public class AudtCaseInfoDQueryDTO extends AudtCaseInfoDDTO implements Serializable{

    private static final long serialVersionUID= 1L;

    @ApiModelProperty(value = "开始时间_开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime begntimeStart;

    @ApiModelProperty(value = "开始时间_结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime begntimeEnd;

    @ApiModelProperty(value = "结束时间_开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime endtimeStart;

    @ApiModelProperty(value = "结束时间_结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private LocalDateTime endtimeEnd;

    @ApiModelProperty(value = "经办时间_开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime optTimeStart;

    @ApiModelProperty(value = "经办时间_结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime optTimeEnd;

    @ApiModelProperty(value = "数据创建时间_开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime crteTimeStart;

    @ApiModelProperty(value = "数据创建时间_结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime crteTimeEnd;

    @ApiModelProperty(value = "数据更新时间_开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updtTimeStart;

    @ApiModelProperty(value = "数据更新时间_结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updtTimeEnd;
}
