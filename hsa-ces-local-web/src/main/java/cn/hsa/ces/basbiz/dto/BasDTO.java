package cn.hsa.ces.basbiz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 基础传输对象
 *
 * @author liweihuang
 */
public class BasDTO {

    @ApiModelProperty(value = "经办时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime optTime;

    @ApiModelProperty(value = "经办人姓名")
    private String opterName;

    @ApiModelProperty(value = "经办人ID")
    private String opterId;

    @ApiModelProperty(value = "经办机构编号")
    private String optinsNo;

    @ApiModelProperty(value = "经办机构名称")
    private String optinsName;

    @ApiModelProperty(value = "数据创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime crteTime;

    @ApiModelProperty(value = "创建人姓名")
    private String crterName;

    @ApiModelProperty(value = "创建人ID")
    private String crterId;

    @ApiModelProperty(value = "数据更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updtTime;

    @ApiModelProperty(value = "医保区划")
    private String admdvs;

    @ApiModelProperty(value = "统筹区编号")
    private String poolareaNo;

    @ApiModelProperty(value = "数据唯一记录号")
    private String rid;

    public LocalDateTime getOptTime() {
        return optTime;
    }

    public void setOptTime(LocalDateTime optTime) {
        this.optTime = optTime;
    }

    public String getOpterName() {
        return opterName;
    }

    public void setOpterName(String opterName) {
        this.opterName = opterName;
    }

    public String getOpterId() {
        return opterId;
    }

    public void setOpterId(String opterId) {
        this.opterId = opterId;
    }

    public String getOptinsNo() {
        return optinsNo;
    }

    public void setOptinsNo(String optinsNo) {
        this.optinsNo = optinsNo;
    }

    public String getOptinsName() {
        return optinsName;
    }

    public void setOptinsName(String optinsName) {
        this.optinsName = optinsName;
    }

    public LocalDateTime getCrteTime() {
        return crteTime;
    }

    public void setCrteTime(LocalDateTime crteTime) {
        this.crteTime = crteTime;
    }

    public String getCrterName() {
        return crterName;
    }

    public void setCrterName(String crterName) {
        this.crterName = crterName;
    }

    public String getCrterId() {
        return crterId;
    }

    public void setCrterId(String crterId) {
        this.crterId = crterId;
    }

    public LocalDateTime getUpdtTime() {
        return updtTime;
    }

    public void setUpdtTime(LocalDateTime updtTime) {
        this.updtTime = updtTime;
    }

    public String getAdmdvs() {
        return admdvs;
    }

    public void setAdmdvs(String admdvs) {
        this.admdvs = admdvs;
    }

    public String getPoolareaNo() {
        return poolareaNo;
    }

    public void setPoolareaNo(String poolareaNo) {
        this.poolareaNo = poolareaNo;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "BasDTO{" +
                "optTime=" + optTime +
                ", opterName='" + opterName + '\'' +
                ", opterId='" + opterId + '\'' +
                ", optinsNo='" + optinsNo + '\'' +
                ", optinsName='" + optinsName + '\'' +
                ", crteTime=" + crteTime +
                ", crterName='" + crterName + '\'' +
                ", crterId='" + crterId + '\'' +
                ", updtTime=" + updtTime +
                ", admdvs='" + admdvs + '\'' +
                ", poolareaNo='" + poolareaNo + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}

