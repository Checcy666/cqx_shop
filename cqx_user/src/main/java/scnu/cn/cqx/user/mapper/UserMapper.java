package scnu.cn.cqx.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import scnu.cn.cqx.user.model.User;

import java.util.List;

/**
 * 用户基本信息 Mapper接口
 * @author chenqianxin
 * @date 2023/9/20 11:15
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> getByUsername(@Param("username") String username);
}
