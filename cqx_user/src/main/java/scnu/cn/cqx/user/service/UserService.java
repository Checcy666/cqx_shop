package scnu.cn.cqx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import scnu.cn.cqx.user.model.User;
import scnu.cn.cqx.user.model.req.UserRegistReq;

/**
 * @author chenqianxin
 * @date 2023/9/20 11:04
 */

@Service
public interface UserService extends IService<User>{
    /**
     * 注册
     * @param userRegistReq
     * @return
     */
    User register(UserRegistReq userRegistReq);

    /**
     * 通过名称获取用户信息
     * @param username
     * @return
     */
    User getByName(@Param("username") String username);

    /**
     * 通过手机号获取用户信息
     * @param telephone
     * @return
     */
    User getByTelephone(@Param("telephone") String telephone);

    /**
     * 修改用户密码
     * @param userId 用户id
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     */
    void updatePassword(Long userId, String oldPwd, String newPwd);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password, String role);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     *
     * @return
     */
    UserCacheService getCacheService();
}
