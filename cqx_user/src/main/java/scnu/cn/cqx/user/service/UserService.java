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


    User register(UserRegistReq userRegistReq);

    User getByName(@Param("username") String username);

    User getByTelephone(@Param("telephone") String telephone);

    void updatePassword(Long userId, String oldPwd, String newPwd);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    //String login(String username, String password);

    /**
     * 获取用户信息
     */
    //UserDetails loadUserByUsername(String username);
}
