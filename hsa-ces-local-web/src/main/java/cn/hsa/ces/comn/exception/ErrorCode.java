package cn.hsa.ces.comn.exception;

/**
 * @author Liweihuang
 */
public interface ErrorCode {

    /**
     * 获取错误码
     * @return
     */
    String getCode();

    /**
     * 获取错误信息
     * @return
     */
    String getDescription();

}
