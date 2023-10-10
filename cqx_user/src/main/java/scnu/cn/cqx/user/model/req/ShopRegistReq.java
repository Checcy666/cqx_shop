package scnu.cn.cqx.user.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 商家注册信息
 * @author chenqianxin
 * @date 2023/10/10 11:45
 */

@Data
public class ShopRegistReq {
    @NotEmpty
    @ApiModelProperty(value = "商家名", required = true)
    private String shopname;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @Email
    @ApiModelProperty(value = "手机号码")
    private String telephone;

    @ApiModelProperty(value = "验证码")
    private String autoCode;
}
