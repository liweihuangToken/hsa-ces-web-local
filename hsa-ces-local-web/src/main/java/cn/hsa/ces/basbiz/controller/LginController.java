package cn.hsa.ces.basbiz.controller;

import cn.hsa.ces.basbiz.bo.AudtCaseInfoDBO;
import cn.hsa.ces.basbiz.dao.AudtCaseInfoDDAO;
import cn.hsa.ces.basbiz.entity.AudtCaseInfoDDO;
import cn.hsa.hsaf.core.framework.HsafController;
import cn.hsa.hsaf.core.framework.web.WrapperResponse;
import cn.hutool.core.lang.func.Func1;
import com.alibaba.fastjson.JSON;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: liweihuang
 * @Date: 2021/07/17
 */
@RequestMapping("/web/lgin")
@RestController
@Slf4j
@Api(value = "/web/lgin", tags = "登录信息")
public class LginController extends HsafController {

    @Autowired
    private AudtCaseInfoDBO audtCaseInfoDBO;
    @Autowired
    private AudtCaseInfoDDAO audtCaseInfoDDAO;

    /**
     * 简介:查询当前登录人员拥有的功能资源信息
     *
     * @author liweihuang
     * @date 2019/12/24
     */
    @PostMapping("/test")
    @ApiOperation(value = "测试接口", notes = "测试接口", httpMethod = "POST")
    public void test(@RequestBody AudtCaseInfoDDO audtCaseInfoDDO2) {
        LambdaQueryWrapper<AudtCaseInfoDDO> wrapper = new LambdaQueryWrapper<>(audtCaseInfoDDO2);
        Func1<AudtCaseInfoDDO, LocalDateTime> getCrteTime = AudtCaseInfoDDO::getCrteTime;
        wrapper.between(AudtCaseInfoDDO::getCrteTime, LocalDateTime.now(), LocalDateTime.now());
        wrapper.orderByDesc(AudtCaseInfoDDO::getCrteTime);
        List<AudtCaseInfoDDO> audtCaseInfoDDOList = audtCaseInfoDDAO.selectList(wrapper);
/*        Page<AudtCaseInfoDDO> page = new Page<>(1, 10);
        IPage<AudtCaseInfoDDO> ipage = audtCaseInfoDDAO.selectPage(page, wrapper);
        List<AudtCaseInfoDDO> list = audtCaseInfoDBO.list();*/
        for (AudtCaseInfoDDO audtCaseInfoDDO : audtCaseInfoDDOList
        ) {
            System.out.println(JSON.toJSONString(audtCaseInfoDDO));
        }
    }

    /**
     * 简介:查询当前登录人员拥有的功能资源信息
     *
     * @author liweihuang
     * @date 2019/12/24
     */
    @DS(value = "master")
    @PostMapping("/test2")
    @ApiOperation(value = "测试接口", notes = "测试接口", httpMethod = "POST")
    public WrapperResponse<List<AudtCaseInfoDDO>> test2(@RequestBody AudtCaseInfoDDO audtCaseInfoDDO2) {
        Page<AudtCaseInfoDDO> page = new Page<>(1, 2);
        List<AudtCaseInfoDDO> list = audtCaseInfoDBO.list();
        return WrapperResponse.success(list);
    }

}
