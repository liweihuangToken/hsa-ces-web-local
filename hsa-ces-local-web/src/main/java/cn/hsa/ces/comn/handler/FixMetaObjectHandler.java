package cn.hsa.ces.comn.handler;

import cn.hsa.ces.basbiz.enums.DelFlagEnum;
import cn.hsa.ces.comn.cons.FillFieldConstants;
import cn.hsa.ces.comn.utils.AppInfoConfigPropertiesUtils;
import cn.hsa.ces.comn.utils.IdGeneratorUtils;
import cn.hsa.hsaf.core.framework.context.HsafContextHolder;
import cn.hsa.hsaf.core.framework.util.CurrentUser;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 固有字段赋值处理器
 *
 * @author Liweihuang
 */
@Slf4j
@Component
public class FixMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        CurrentUser currentUser = getCurrentUser();
        LocalDateTime nowTime = LocalDateTimeUtil.now();
        if (metaObject.hasGetter(FillFieldConstants.Crte.FILL_RID)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Crte.FILL_RID, () -> IdGeneratorUtils.getRid(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Crte.FILL_DELFLAG)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Crte.FILL_DELFLAG, () -> DelFlagEnum.DEL_FLAG_NO.getCode(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Crte.FILL_CRTERNAME)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Crte.FILL_CRTERNAME, () -> currentUser.getName(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Crte.FILL_CRTERID)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Crte.FILL_CRTERID, () -> currentUser.getUserAcctID(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Crte.FILL_CRTETIME)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Crte.FILL_CRTETIME, () -> nowTime, LocalDateTime.class);
        }
        updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        CurrentUser currentUser = getCurrentUser();
        LocalDateTime nowTime = LocalDateTimeUtil.now();
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_UPDTTIME)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_UPDTTIME, () -> nowTime, LocalDateTime.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_OPTTIME)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_OPTTIME, () -> nowTime, LocalDateTime.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_OPTERNAME)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_OPTERNAME, () -> currentUser.getName(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_OPTERID)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_OPTERID, () -> currentUser.getUserAcctID(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_OPTINSNO)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_OPTINSNO, () -> currentUser.getDeptID(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_OPTINSNAME)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_OPTINSNAME, () -> currentUser.getDeptName(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_ADMDVS)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_ADMDVS, () -> currentUser.getAdmDvs(), String.class);
        }
        if (metaObject.hasGetter(FillFieldConstants.Opt.FILL_POOLAREANO)) {
            this.strictInsertFill(metaObject, FillFieldConstants.Opt.FILL_POOLAREANO, () -> currentUser.getAdmDvs(), String.class);
        }
    }

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    private CurrentUser getCurrentUser() {
        CurrentUser currentUser = HsafContextHolder.getContext().getCurrentUser();
        if (null == currentUser || CharSequenceUtil.isBlank(currentUser.getUserAcctID())) {
            CurrentUser cu = new CurrentUser();
            String admdvs = AppInfoConfigPropertiesUtils.getInstance().getAdmdvs();
            String optName = "系统操作";
            cu.setName(optName);
            cu.setDeptName(optName);
            cu.setUserAcctID(admdvs);
            cu.setDeptID(admdvs);
            cu.setAdmDvs(admdvs);
            return cu;
        }
        return currentUser;
    }
}
