package scnu.cn.cqx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import scnu.cn.cqx.user.model.Cart;

/**
 * @author chenqianxin
 * @date 2023/10/10 11:04
 */

@Service
public interface CartService extends IService<Cart> {

    Boolean insertGoodsToCart(Cart insertCart);
}
