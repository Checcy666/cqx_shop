package scnu.cn.cqx.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import scnu.cn.cqx.user.model.Goods;

/**
 * @author chenqianxin
 * @date 2023/10/12 16:08
 */

public interface GoodsMapper extends BaseMapper<Goods> {


    Integer queryGoodsAllCount();

    /**
     * TODO 可以优化
     * @param goods
     * @return
     */
    Integer queryGoodsCount(@Param("goods") Goods goods);
}
