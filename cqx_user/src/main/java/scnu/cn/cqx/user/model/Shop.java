package scnu.cn.cqx.user.model;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家信息表
 * @author chenqianxin
 * @date 2023/10/8 15:06
 */

@TableName("shop")
public class Shop implements Serializable {

    /**
     * 商家id
     */
    private Long shopId;

    /**
     * 商家名称
     */
    private String shopname;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 商家简介
     */
    private String shopDescribe;

    /**
     * 注册时间
     */
    private Date createTime;

    /**
     * 商家状态，0-正常，1-关闭
     */
    private Integer status;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopDescribe() {
        return shopDescribe;
    }

    public void setShopDescribe(String shopDescribe) {
        this.shopDescribe = shopDescribe;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
