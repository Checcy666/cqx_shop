package scnu.cn.cqx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import scnu.cn.cqx.user.model.Shop;
import scnu.cn.cqx.user.model.req.ShopRegistReq;

/**
 * @author chenqianxin
 * @date 2023/9/20 11:04
 */

@Service
public interface ShopService extends IService<Shop> {
    /**
     * 注册
     * @param shopRegistReq
     * @return
     */
    Shop register(ShopRegistReq shopRegistReq);

    /**
     * 通过名称获取商家信息
     * @param username
     * @return
     */
    Shop getByName(@Param("username") String username);

    /**
     * 通过手机号获取商家信息
     * @param telephone
     * @return
     */
    Shop getByTelephone(@Param("telephone") String telephone);

    /**
     * 修改商家密码
     * @param shopId 商家id
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     */
    void updatePassword(Long shopId, String oldPwd, String newPwd);

}
