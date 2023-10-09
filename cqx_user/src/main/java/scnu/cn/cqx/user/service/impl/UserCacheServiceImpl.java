package scnu.cn.cqx.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import scnu.cn.cqx.common.service.RedisService;
import scnu.cn.cqx.user.model.User;
import scnu.cn.cqx.user.service.UserCacheService;
import scnu.cn.cqx.user.service.UserService;

/**
 * @author chenqianxin
 * @date 2023/9/28 15:53
 */

public class UserCacheServiceImpl implements UserCacheService {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    //查
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;
    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delUser(Long userId) {

    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public void setUser(User user) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + user.getUsername();
        redisService.set(key, user, REDIS_EXPIRE);
    }

    @Override
    public void setAuthCode(String telephone, String authCode) {

    }

    @Override
    public String getAuthCode(String telephone) {
        return null;
    }
}
