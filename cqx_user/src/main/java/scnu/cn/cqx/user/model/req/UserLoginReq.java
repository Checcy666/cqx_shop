package scnu.cn.cqx.user.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录信息
 * @author chenqianxin
 * @date 2023/9/20 14:02
 */
@Data
@EqualsAndHashCode
public class UserLoginReq {

    @NotEmpty
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
