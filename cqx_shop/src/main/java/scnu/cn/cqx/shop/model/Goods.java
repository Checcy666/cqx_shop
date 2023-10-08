package scnu.cn.cqx.shop.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author chenqianxin
 * @date 2023/10/8 15:37
 */

@TableName("goods")
public class Goods implements Serializable {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商家id
     */
    private Long shopId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private double goodsPrice;

    /**
     * 商品详情
     */
    private String goodsDescribe;

    /**
     * 商品数量
     */
    private int goodsCount;

    /**
     * 商品成交数量
     */
    private int goodsDealCount;

    /**
     * 商品类别
     */
    private String goodsType;

    /**
     * 商品打折价
     */
    private double goodsDiscountPrice;

    /**
     * 商品图片存储路径
     */
    private String picturePath;

    /**
     * 商品状态，0-正常售卖，1-已售完，2-已下架
     */
    private Integer status;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getGoodsDealCount() {
        return goodsDealCount;
    }

    public void setGoodsDealCount(int goodsDealCount) {
        this.goodsDealCount = goodsDealCount;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public double getGoodsDiscountPrice() {
        return goodsDiscountPrice;
    }

    public void setGoodsDiscountPrice(double goodsDiscountPrice) {
        this.goodsDiscountPrice = goodsDiscountPrice;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
