package cn.hsa.ces.mq.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 消息队列 消息内容DTO
 * </p>
 *
 * @author liweihuang
 * @since 2019-11-06
 */

@ApiModel(value = "消息队列 消息内容DTO", description = "消息队列 消息内容DTO")
@Data
public class MsgDTO implements Serializable {

    private static final long serialVersionUID = 1928829689068589345L;

    @ApiModelProperty(value = "id ")
    private Integer id;

    @ApiModelProperty(value = "姓名 ")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "地址")
    private String addr;

}
