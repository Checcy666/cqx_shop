package scnu.cn.cqx.user.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户注册信息
 * @author chenqianxin
 * @date 2023/9/20 11:35
 */
@Data
public class UserRegistReq {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @Email
    @ApiModelProperty(value = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "验证码")
    private String autoCode;

}
