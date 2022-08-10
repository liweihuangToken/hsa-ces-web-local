package cn.hsa.ces.comn.utils;

import cn.hsa.hsaf.core.framework.util.PageResult;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * dozer 转换器
 *
 * @author liweihuang
 * @date 2021-06-25
 */
@Component
public class GeneralConvertorUtils {

    private GeneralConvertorUtils(){}

    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    @Autowired
    public static final Mapper DOZER_MAPPER = DozerBeanMapperBuilder.buildDefault();

    /**
     * List  实体类 转换器
     *
     * @param source 原数据
     * @param clz    转换类型
     * @param <S>
     */
    public static <T, S> List<T> convertor(List<S> source, Class<T> clz) {
        if (null == source) {
            return null;
        }
        List<T> map = new ArrayList<>();
        for (S s : source) {
            map.add(DOZER_MAPPER.map(s, clz));
        }
        return map;
    }

    /**
     * Set 实体类 深度转换器
     *
     * @param source 原数据
     * @param clz    目标对象
     * @param <T>
     * @return
     */
    public static <T, S> Set<T> convertor(Set<S> source, Class<T> clz) {
        if (null == source) {
            return null;
        }
        Set<T> set = new TreeSet<>();
        for (S s : source) {
            set.add(DOZER_MAPPER.map(s, clz));
        }
        return set;
    }

    /**
     * 实体类 深度转换器
     *
     * @param source
     * @param clz
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> T convertor(S source, Class<T> clz) {
        if (source == null) {
            return null;
        }
        return DOZER_MAPPER.map(source, clz);
    }


    public static void convertor(Object source, Object object) {
        DOZER_MAPPER.map(source, object);
    }

    public static <T> void copyConvertor(T source, Object object) {
        DOZER_MAPPER.map(source, object);
    }

    /**
     * PageInfo转PageResult
     *
     * @param clz
     * @param source
     * @return
     */
    public static <T, S> PageResult<T> convertor(Class<T> clz, List<S> source) {
        PageInfo<S> pageInfo = new PageInfo<S>(source);
        PageResult pageResult = new PageResult<>((int) pageInfo.getTotal()
                , pageInfo.getPages()
                , pageInfo.getPageSize()
                , pageInfo.getPageNum()
                , convertor(source, clz));
        return pageResult;
    }

    /**
     * PageResult<class1>转PageResult<class2>
     *
     * @param clz
     * @param source
     * @return
     */
    public static <T, S> PageResult convertor(Class<T> clz, PageResult<S> source) {
        PageResult pageResult = new PageResult<T>(source.getRecordCounts()
                , source.getPages()
                , source.getPageSize()
                , source.getPageNum()
                , convertor(source.getData(), clz));
        return pageResult;
    }

}
