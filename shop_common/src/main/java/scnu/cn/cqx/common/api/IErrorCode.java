package scnu.cn.cqx.common.api;

/**
 * API返回码接口
 * @author chenqianxin
 * @date 2023/9/20 11:22
 */
public interface IErrorCode {
    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();

}

