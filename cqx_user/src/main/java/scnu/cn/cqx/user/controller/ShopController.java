package scnu.cn.cqx.user.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scnu.cn.cqx.common.api.CommonResult;

import scnu.cn.cqx.user.model.Shop;
import scnu.cn.cqx.user.model.User;
import scnu.cn.cqx.user.model.req.ShopRegistReq;
import scnu.cn.cqx.user.model.req.UpdatePasswordReq;
import scnu.cn.cqx.user.model.req.UserLoginReq;
import scnu.cn.cqx.user.service.ShopService;
import scnu.cn.cqx.user.service.UserCacheService;

import javax.validation.Valid;

/**
 * @author chenqianxin
 * @date 2023/10/8 17:51
 */

@RestController
@Api(tags = {"商家管理接口"})
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private UserCacheService userCacheService;

    @PostMapping(value = "/register")
    @ApiOperation("商家注册")
    public CommonResult<Shop> register(@Valid @RequestBody ShopRegistReq shopRegistReq){
        //查看是否存在相同用户名
        Shop exitShop = shopService.getByName(shopRegistReq.getShopname());
        if(exitShop == null){
            CommonResult.failed("商家名已被使用");
        }
        if(StringUtils.isNotBlank(shopRegistReq.getTelephone())){
            exitShop = shopService.getByTelephone(shopRegistReq.getTelephone());
            if(exitShop == null){
                CommonResult.failed("手机号已被使用");
            }
        }
        //验证验证码
        if(!verifyAuthCode(shopRegistReq.getAutoCode(),shopRegistReq.getTelephone())){
            CommonResult.failed("验证码错误");
        }
        Shop newShop = shopService.register(shopRegistReq);
        if(newShop == null){
            return CommonResult.failed();
        }
        return CommonResult.success(null,"注册成功");
    }

    @PostMapping(value = "/login")
    @ApiOperation("商家登录")
    public CommonResult shopLogin(UserLoginReq userLoginReq){
        //登录超时
        String token = userService.login(userLoginReq.getUsername(),userLoginReq.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //下面三行有什么用
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success("商家登录成功");
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取商户详情")
    public Shop getById(@PathVariable Long id){
        return shopService.getById(id);
    }

    @PostMapping(value = "/updatePassword")
    @ApiOperation("修改密码")
    public void updatePassword(@Valid @RequestBody UpdatePasswordReq updatePasswordReq) {
        shopService.updatePassword(updatePasswordReq.getId(), updatePasswordReq.getOldPwd(), updatePasswordReq.getNewPwd());
    }

    //对输入的验证码进行校验
    //usercontroller也同样用
    private boolean verifyAuthCode(String authCode, String telephone){
        //将StrUtil改成StringUtil
        if(StringUtil.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = userCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }

}
