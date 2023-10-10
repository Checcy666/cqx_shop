package scnu.cn.cqx.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import scnu.cn.cqx.common.api.CommonResult;
import scnu.cn.cqx.user.mapper.ShopMapper;
import scnu.cn.cqx.user.model.Shop;
import scnu.cn.cqx.user.model.User;
import scnu.cn.cqx.user.model.req.ShopRegistReq;
import scnu.cn.cqx.user.service.ShopService;

import java.util.Date;

/**
 * 商家服务实现类
 * @author chenqianxin
 * @date 2023/10/10 11:38
 */

public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop register(ShopRegistReq shopRegistReq) {
        Shop newShop = new Shop();
        newShop.setShopname(shopRegistReq.getShopname());
        newShop.setPassword(shopRegistReq.getPassword());
        newShop.setTelephone(shopRegistReq.getTelephone());
        newShop.setStatus(0);
        newShop.setCreateTime(new Date(System.currentTimeMillis()));
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(newShop.getPassword());
        newShop.setPassword(encodePassword);

        shopMapper.insert(newShop);
        return newShop;
    }

    @Override
    public Shop getByName(String shopname) {
        return getOne(new QueryWrapper<Shop>().eq("shopname", shopname));
    }

    @Override
    public Shop getByTelephone(String telephone) {
        return getOne(new QueryWrapper<Shop>().eq("telephone", telephone));
    }

    @Override
    public void updatePassword(Long shopId, String oldPwd, String newPwd) {
        Shop updateShop = getById(shopId);
        if(updateShop.getPassword().equals(oldPwd)){
            CommonResult.failed("原密码错误，请重新输入");
        }
        if(oldPwd.equals(newPwd)){
            CommonResult.failed("新密码与原密码相同，请重新输入");
        }
        updateShop.setPassword(newPwd);
        if (!updateById(updateShop)){
            CommonResult.failed("修改密码失败");
        }
    }

}
