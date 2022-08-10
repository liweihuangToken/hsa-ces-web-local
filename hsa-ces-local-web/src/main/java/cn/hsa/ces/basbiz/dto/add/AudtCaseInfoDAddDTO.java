package cn.hsa.ces.basbiz.dto.add;

import cn.hsa.ces.basbiz.dto.bas.AudtCaseInfoDDTO;
import cn.hsa.ces.comn.utils.IdGeneratorUtils;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 稽核案件信息表新增传输对象
 * </p>
 *
 * @author liweihuang
 * @since 2021-07-23
 */
@ApiModel(value = "稽核案件信息表新增传输对象", description = "稽核案件信息表新增传输对象")
@Data
public class AudtCaseInfoDAddDTO extends AudtCaseInfoDDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String AUDT_CASE_INFO_D_ADD = "AUDT_CASE_INFO_D:ADD";

    public static String getKey() {
        return IdGeneratorUtils.getStrPkId(AUDT_CASE_INFO_D_ADD);
    }

}
