package scnu.cn.cqx.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.CollectionUtils;
import scnu.cn.cqx.common.api.CommonResult;
import scnu.cn.cqx.user.mapper.UserMapper;
import scnu.cn.cqx.user.model.User;
import scnu.cn.cqx.user.model.req.UserRegistReq;
import scnu.cn.cqx.user.service.UserCacheService;
import scnu.cn.cqx.user.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * 用户服务实现类
 * @author chenqianxin
 * @date 2023/9/20 11:15
 */
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserCacheService userCacheService;

    @Override
    public User register(UserRegistReq userRegistReq) {
        User newUser = new User();
        newUser.setUsername(userRegistReq.getUsername());
        newUser.setPassword(userRegistReq.getPassword());
        newUser.setTelephone(userRegistReq.getTelephone());
        newUser.setStatus(1);
        newUser.setCreateTime(new Date(System.currentTimeMillis()));
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodePassword);

        userMapper.insert(newUser);
        return newUser;
    }

    @Override
    public User getByName(String username) {
        return getOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public User getByTelephone(String telephone) {
        return getOne(new QueryWrapper<User>().eq("telephone", telephone));
    }

    @Override
    public void updatePassword(Long userId, String oldPwd, String newPwd) {
        User updateUser = getById(userId);
        if(updateUser.getPassword().equals(oldPwd)){
            CommonResult.failed("原密码错误，请重新输入");
        }
        if(oldPwd.equals(newPwd)){
            CommonResult.failed("新密码与原密码相同，请重新输入");
        }
        updateUser.setPassword(newPwd);
        if (!updateById(updateUser)){
            CommonResult.failed("修改密码失败");
        }
    }

    /*@Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;

    }*/

    /*@Override
    public UserDetails loadUserByUsername(String username) {
        User user = getByUsername(username);
        if(user!=null){
            return new MemberDetails(user);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
        //验证用户名与密码匹配
    }*/

    /*private User getByUsername(String username) {
        User user = userCacheService.getUser(username);
        if(user!=null)
            return user;
        *//*UmsMemberExample example = new UmsMemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsMember> memberList = memberMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(memberList)) {
            member = memberList.get(0);
            memberCacheService.setMember(member);
            return member;
        }*//*
        return null;
    }*/
}
