package scnu.cn.cqx.user.service;

import scnu.cn.cqx.user.model.User;

/**
 * 用户信息缓存业务类
 * @author chenqianxin
 * @date 2023/9/22 11:05
 */

public interface UserCacheService {

    /**
     * 删除会员用户缓存
     */
    void delUser(Long userId);

    /**
     * 获取会员用户缓存
     */
    User getUser(String username);

    /**
     * 设置会员用户缓存
     */
    void setUser(User user);

    /**
     * 设置验证码
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     */
    String getAuthCode(String telephone);
}
