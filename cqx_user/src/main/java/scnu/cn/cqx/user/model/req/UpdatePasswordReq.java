package scnu.cn.cqx.user.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chenqianxin
 * @date 2023/9/20 15:04
 */
@Data
public class UpdatePasswordReq {
    /**
     * 原密码（需要md5加密一次）
     */
    @NotBlank(message = "原密码不能为空")
    @ApiModelProperty(value = "原密码", required = true)
    private String oldPwd;

    /**
     * 新密码（需要md5加密一次）
     */
    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty(value = "新密码", required = true)
    private String newPwd;

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Long id;

}
