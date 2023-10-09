package scnu.cn.cqx.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import scnu.cn.cqx.common.api.CommonResult;

/**
 * @author chenqianxin
 * @date 2023/10/8 17:51
 */

@RestController
@Api(tags = {"商家管理接口"})
public class ShopController {

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
}
