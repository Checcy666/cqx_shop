package scnu.cn.cqx.user.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author chenqianxin
 * @date 2023/10/8 15:45
 */

@TableName("cart")
public class Cart implements Serializable {

    /**
     * 购物车代理主键
     */
    private Long cartId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private int goodsCount;

    /**
     * 商品添加到购物车的价格
     */
    private double goodsPrice;

    /**
     * 商品状态，0-在购物车中，1-已购买，2-已从购物车中删除
     */
    private Integer status;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
