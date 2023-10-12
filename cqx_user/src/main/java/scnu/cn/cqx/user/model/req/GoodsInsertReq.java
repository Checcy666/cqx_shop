package scnu.cn.cqx.user.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author chenqianxin
 * @date 2023/10/12 16:58
 */

@Data
public class GoodsInsertReq {
    @NotEmpty
    @ApiModelProperty(value = "商品id", required = true)
    private Long goodsId;

    @NotEmpty
    @ApiModelProperty(value = "商家id", required = true)
    private Long shopId;

    @NotEmpty
    @ApiModelProperty(value = "商品名", required = true)
    private String goodsName;

    @NotEmpty
    @ApiModelProperty(value = "商品价格", required = true)
    private double goodsPrice;

    @ApiModelProperty(value = "商品详情")
    private String goodsDescribe;

    @NotEmpty
    @ApiModelProperty(value = "商品数量", required = true)
    private int goodsCount;

    @NotEmpty
    @ApiModelProperty(value = "商品类别", required = true)
    private String goodsType;

    @NotEmpty
    @ApiModelProperty(value = "商品打折价", required = true)
    private double goodsDiscountPrice;

    @NotEmpty
    @ApiModelProperty(value = "商品图片存储路径", required = true)
    private String picturePath;

    @NotEmpty
    @ApiModelProperty(value = "商品状态", required = true)
    private Integer status;
}
