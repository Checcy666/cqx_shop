package scnu.cn.cqx.user.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import scnu.cn.cqx.user.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author chenqianxin
 * @date 2023/9/20 17:03
 */
@Data
public class UpdateUserReq {

    @ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为null")
    private Long id;

    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "手机号码，可用于密码重置等")
    private String telephone;

    /*@ApiModelProperty(value = "邮箱")
    private String email;*/


    public User convertFrom(UpdateUserReq updateUserReq) {
        if (updateUserReq == null) {
            return null;
        }
        User updateUser = new User();
        //todo 取消copy方法
        BeanUtils.copyProperties(updateUserReq, updateUser);
        return updateUser;
    }
}
