package scnu.cn.cqx.user.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;
import scnu.cn.cqx.common.api.CommonResult;
import scnu.cn.cqx.user.model.User;
import scnu.cn.cqx.user.model.req.UpdatePasswordReq;
import scnu.cn.cqx.user.model.req.UpdateUserReq;
import scnu.cn.cqx.user.model.req.UserLoginReq;
import scnu.cn.cqx.user.model.req.UserRegistReq;
import scnu.cn.cqx.user.service.UserCacheService;
import scnu.cn.cqx.user.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * @author chenqianxin
 * @date 2023/9/20 10:59
 */
@RestController
@Api(tags = {"用户管理接口"})
public class UserController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserService userService;
    @Autowired
    private UserCacheService userCacheService;

    @PostMapping(value = "/registerCommmon")
    @ApiOperation("普通用户注册")
    public CommonResult<User> register(@Valid @RequestBody UserRegistReq userRegistReq){
        //查看是否存在相同用户名
        User exitUser = userService.getByName(userRegistReq.getUsername());
        if(exitUser == null){
            CommonResult.failed("用户名已被使用");
        }
        if(StringUtils.isNotBlank(userRegistReq.getTelephone())){
            exitUser = userService.getByTelephone(userRegistReq.getTelephone());
            if(exitUser == null){
                CommonResult.failed("手机号已被使用");
            }
        }
        //验证验证码
        if(!verifyAuthCode(userRegistReq.getAutoCode(),userRegistReq.getTelephone())){
            CommonResult.failed("验证码错误");
        }
        User newUser = userService.register(userRegistReq);
        if(newUser == null){
            return CommonResult.failed();
        }
        return CommonResult.success(null,"注册成功");
    }

    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public CommonResult userLogin(UserLoginReq userLoginReq){
        //登录超时
        String token = userService.login(userLoginReq.getUsername(),userLoginReq.getPassword(),"1");
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //下面三行有什么用
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success("用户登录成功");
    }

    @PostMapping(value = "/login")
    @ApiOperation("商家登录")
    public CommonResult shopLogin(UserLoginReq userLoginReq){
        //登录超时
        String token = userService.login(userLoginReq.getUsername(),userLoginReq.getPassword(),"2");
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        //下面三行有什么用
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success("商家登录成功");
    }

    @PostMapping(value = "/logout")
    @ApiOperation("退出登录")
    public CommonResult logout(){
        return CommonResult.success(null);
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation("获取用户详情")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping(value = "/updatePassword")
    @ApiOperation("修改密码")
    public void updatePassword(@Valid @RequestBody UpdatePasswordReq updatePasswordReq) {
        userService.updatePassword(updatePasswordReq.getUserId(), updatePasswordReq.getOldPwd(), updatePasswordReq.getNewPwd());
    }

    @PostMapping(value = "/update")
    @ApiOperation("更新用户信息")
    public void update(@Valid @RequestBody UpdateUserReq updateUserReq){
        if (StringUtils.isNotBlank(updateUserReq.getTelephone())){
            User exitUser = userService.getByTelephone(updateUserReq.getTelephone());
            if(exitUser == null || updateUserReq.getId().equals(exitUser.getId())){
                CommonResult.failed("手机号码已存在");
            }
        }
        User updateUser = updateUserReq.convertFrom(updateUserReq);
        userService.updateById(updateUser);
    }

    //对输入的验证码进行校验
    private boolean verifyAuthCode(String authCode, String telephone){
        //将StrUtil改成StringUtil
        if(StringUtil.isEmpty(authCode)){
            return false;
        }
        String realAuthCode = userCacheService.getAuthCode(telephone);
        return authCode.equals(realAuthCode);
    }

}
