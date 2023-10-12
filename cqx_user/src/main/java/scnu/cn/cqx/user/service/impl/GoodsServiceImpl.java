package scnu.cn.cqx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import scnu.cn.cqx.user.mapper.GoodsMapper;
import scnu.cn.cqx.user.model.Goods;
import scnu.cn.cqx.user.service.GoodsService;

/**
 * 商品服务实现类
 * @author chenqianxin
 * @date 2023/10/11 17:38
 */

public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 与下面的updateGoodsCount方法一样，都需要验证goodsId的存在性，如果不存在需要给出错误提示
     *
     * @param goodsId
     * @param status
     * @return
     */
    @Override
    public Boolean updateGoodsStatus(Long goodsId, Integer status) {
        Goods goods = goodsMapper.selectById(goodsId);
        Integer goodsCount = goods.getGoodsCount();
        // 商品数量为0的商品不可以将状态设置为在出售
        if (goodsCount == 0 && status == 0) {
            return false;
        }
        Goods finalGoods = new Goods();
        finalGoods.setStatus(status);
        finalGoods.setGoodsId(goodsId);
        int update = goodsMapper.updateById(finalGoods);
        if(update==1){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Integer queryGoodsCount(Goods goods) {
        if (goods==null){
            return goodsMapper.queryGoodsAllCount();
        }
        return goodsMapper.queryGoodsCount(goods);
    }
}
