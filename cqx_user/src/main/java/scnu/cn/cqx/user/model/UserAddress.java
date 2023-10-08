package scnu.cn.cqx.user.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author chenqianxin
 * @date 2023/10/8 15:31
 */

@TableName("user_address")
public class UserAddress implements Serializable {
    /**
     * 收货地址代理主键
     */
    private Long addressId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 收货人名称
     */
    private  String uname;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 是否为默认，0-否，1-是
     */
    private Integer defaultStatus;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
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
