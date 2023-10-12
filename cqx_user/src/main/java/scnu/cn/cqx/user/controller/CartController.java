package scnu.cn.cqx.user.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scnu.cn.cqx.common.api.CommonResult;
import scnu.cn.cqx.user.model.Cart;
import scnu.cn.cqx.user.model.Shop;
import scnu.cn.cqx.user.service.CartService;

import java.util.List;

/**
 * @author chenqianxin
 * @date 2023/10/8 17:51
 */

@RestController
@Api(tags = {"购物车管理接口"})
public class CartController {
    @Autowired
    private CartService cartService;


    @PostMapping("/insertToCart")
    public CommonResult insertToCar(Cart insertCart) {
        Boolean aBoolean = cartService.insertGoodsToCart(insertCart);
        if (aBoolean)
            return  CommonResult.success(null,"加入购物车成功");
        return CommonResult.failed("加入购物车失败");
    }

    /*@GetMapping("/updateCount")
    public ResultMessage updateCount(@RequestParam String goodsUUID, @RequestParam String commonId, @RequestParam Boolean countUpper) {
        Boolean aBoolean = shopCarService.updateCount(goodsUUID, commonId, countUpper);
        if (aBoolean)
            return new ResultMessage(UPDATE_SHOPCAR_COUNT_SUCCESS);
        return new ResultMessage(UPDATE_SHOPCAR_COUNT_FAIL);
    }

    @GetMapping("/getGoodsListInCar")
    public ResultMessage getGoodsListInCar(@RequestParam String commonId, @RequestParam String status) {
        List<ShopCar> goodsListByCommonId = shopCarService.getGoodsListByCommonId(commonId, status);
        return new ResultMessage(DATA_RETURN_SUCCESS, goodsListByCommonId);
    }

    @GetMapping("/getGoodsByCommonIdAndUUID")
    public ResultMessage getGoodsByCommonIdAndUUID(@RequestParam String goodsUUID, @RequestParam String commonId) {
        ShopCar goodsByCommonIdAndUUID = shopCarService.getGoodsByCommonIdAndUUID(goodsUUID, commonId);
        return new ResultMessage(DATA_RETURN_SUCCESS, goodsByCommonIdAndUUID);
    }

    @GetMapping("/updateStatus")
    public ResultMessage updateStatus(@RequestParam String goodsUUID, @RequestParam String commonId, @RequestParam String status) {
        Boolean aBoolean = shopCarService.updateStatus(goodsUUID, commonId, status);
        if (aBoolean)
            return new ResultMessage(UPDATE_SHOPCAR_STATUS_SUCCESS);
        return new ResultMessage(UPDATE_SHOPCAR_STATUS_FAIL);

    }*/
}
