package scnu.cn.cqx.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import scnu.cn.cqx.user.mapper.CartMapper;
import scnu.cn.cqx.user.mapper.GoodsMapper;
import scnu.cn.cqx.user.model.Cart;
import scnu.cn.cqx.user.model.Goods;
import scnu.cn.cqx.user.service.CartService;

/**
 * 购物车服务实现类
 * @author chenqianxin
 * @date 2023/10/11 17:28
 */

public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public Boolean insertGoodsToCart(Cart insertCart) {
        /*Goods goods = goodsMapper.queryGoodsByUUID(shopCar.getGoodsUUID());
        String goodsStatus = goods.getStatus();
        Integer goodsCount = goods.getGoodsCount();
        Integer carCount = shopCar.getGoodsCount();
        if (goods != null && goodsStatus.equals("1") && goodsCount >= carCount) {
            Boolean aBoolean = shopCarMapper.insertGoodsToCar(shopCar);
            return aBoolean;
        }
        return false;*/
    }
}
