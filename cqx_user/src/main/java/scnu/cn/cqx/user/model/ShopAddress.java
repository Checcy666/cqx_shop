package scnu.cn.cqx.user.model;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author chenqianxin
 * @date 2023/10/8 15:38
 */

@TableName("shop_address")
public class ShopAddress {
    /**
     * 收货地址代理主键
     */
    private Long addressId;

    /**
     * 地址名称
     */
    private String addressName;

    /**
     * 商家id
     */
    private Long shopId;

    /**
     * 收发货人名称
     */
    private  String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 是否为默认发货地址，0-否，1-是
     */
    private Integer sendStatus;

    /**
     * 是否为默认收货地址，0-否，1-是
     */
    private Integer receiveStatus;

    /**
     * 省份/直辖市
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 区/镇
     */
    private String region;

    /**
     * 详细地址（街道）
     */
    private String detail_address;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getReceiveStatus() {
        return receiveStatus;
    }

    public void setReceiveStatus(Integer receiveStatus) {
        this.receiveStatus = receiveStatus;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetail_address() {
        return detail_address;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }
}
