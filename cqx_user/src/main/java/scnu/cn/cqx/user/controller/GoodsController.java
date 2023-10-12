package scnu.cn.cqx.user.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scnu.cn.cqx.common.api.CommonResult;
import scnu.cn.cqx.user.model.Goods;
import scnu.cn.cqx.user.model.req.GoodsInsertReq;
import scnu.cn.cqx.user.service.GoodsService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenqianxin
 * @date 2023/10/8 17:51
 */

@RestController
@Api(tags = {"商品管理接口"})
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 这里的goodsType参数，应为typeCode
     *
     * @param goods
     * @return
     */
    @PostMapping("/insertGoods")
    public CommonResult insertGoods(GoodsInsertReq goodsInsertReq) {
//        if (goodsInsertReq != null ) {
//            try {
//                List<GoodsPicture> pictureUrlList = new ArrayList<>();
//                String goodsUUID = CodeUtil.get_uuid();
//                String shopUUID = goods.getShopUUID();
//                goods.setGoodsUUID(goodsUUID);
//                Integer discount = goods.getDiscount();
//                Double goodsPrice = goods.getGoodsPrice();
//                goods.setGoodsDiscountPrice(goodsPrice * discount / 100);
//                Integer count = 0;
//                for (int i = 0; i < goodsPictures.length; i++) {
//                    Boolean aBoolean = PictureUtil.uploadPicture(goodsPictures[i], shopUUID, goodsUUID, null);
//                    if (aBoolean) {
//                        count++;
//                    } else
//                        return new ResultMessage(ERROR_NETWORK);
//                }
//                if (count == goodsPictures.length) {
//                    List<String> goodsUrl = PictureUtil.getGoodsUrl(shopUUID, goodsUUID);
//                    for (String path : goodsUrl) {
//                        GoodsPicture goodsPicture = new GoodsPicture();
//                        goodsPicture.setGoodsUUID(goodsUUID);
//                        goodsPicture.setPicturePath(path);
//                        pictureUrlList.add(goodsPicture);
//                    }
//                } else
//                    return new ResultMessage(ERROR_NETWORK);
//                Boolean aBoolean = goodsService.insertGoods(goods, pictureUrlList);
//                if (aBoolean) {
//                    return new ResultMessage(GOODS_INSERT_SUCCESS);
//                } else {
//                    return new ResultMessage(GOODS_INSERT_FAIL);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new ResultMessage(ERROR_PARAM);
//            }
//        } else {
//            return new ResultMessage(ERROR_NULL);
//        }
    }
//
//    /**
//     * typeCode与上面方法一样
//     *
//     * @param goods
//     * @param goodsPictures
//     * @return
//     * @throws Exception
//     */
//    @PostMapping("/updateGoodsInfo")
//    public ResultMessage updateGoodsInfo(Goods goods, @RequestPart(required = false) MultipartFile[] goodsPictures) throws Exception {
//        String goodsUUID = goods.getGoodsUUID();
//        Goods goodsByUUID = goodsService.getGoodsByUUID(goodsUUID);
//        String shopUUID = goodsByUUID.getShopUUID();
//        List<GoodsPicture> pictureUrlList = new ArrayList<>();
//        if (goodsByUUID != null) {
//            Integer discount = goods.getDiscount();
//            goods.setGoodsDiscountPrice(goods.getGoodsPrice() * discount / 100);
//            try {
//                Integer count = 0;
//                if (goodsPictures != null) {
//                    for (int i = 0; i < goodsPictures.length; i++) {
//                        Boolean aBoolean = PictureUtil.uploadPicture(goodsPictures[i], shopUUID, goodsUUID, null);
//                        if (aBoolean) {
//                            count++;
//                        } else
//                            return new ResultMessage(ERROR_NETWORK);
//                    }
//                    if (count == goodsPictures.length) {
//                        List<String> goodsUrl = PictureUtil.getGoodsUrl(shopUUID, goodsUUID);
//                        for (String path : goodsUrl) {
//                            GoodsPicture goodsPicture = new GoodsPicture();
//                            goodsPicture.setGoodsUUID(goodsUUID);
//                            goodsPicture.setPicturePath(path);
//                            pictureUrlList.add(goodsPicture);
//                        }
//                    } else
//                        return new ResultMessage(ERROR_NETWORK);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new ResultMessage(ERROR_NETWORK);
//            }
//            Boolean aBoolean = goodsService.updateGoodsInfo(goods, pictureUrlList);
//            if (aBoolean) {
//                return new ResultMessage(UPDATE_GOODS_INFO_SUCCESS);
//            } else {
//                return new ResultMessage(UPDATE_GOODS_INFO_FAIL);
//            }
//        } else {
//            return new ResultMessage(ERROR_NOFOUND_GOODS);
//        }
//
//    }

    @GetMapping("/getGoodsById")
    public CommonResult getGoodsById(@RequestParam String goodsId) {
        Goods goodsById = goodsService.getById(goodsId);
        if (goodsById != null) {
            return CommonResult.success(null,"通过id获取商品信息成功");
        }
        return CommonResult.failed("通过id获取商品信息失败");
    }

    @GetMapping("/changeGoodsStatus")
    public CommonResult changeGoodStatus(@RequestParam Long goodsId, @RequestParam Integer status) {
        Goods goodsById = goodsService.getById(goodsId);
        if (goodsById != null) {
            Boolean aBoolean = goodsService.updateGoodsStatus(goodsId, status);
            if (aBoolean){
                return CommonResult.success(null,"改变商品状态成功");
            } else{
                return CommonResult.failed("更新失败");
            }
        } else{
            return CommonResult.failed("商品不存在");
        }
    }


    /*@GetMapping("/getGoodsType")
    public CommonResult getGoodsType() {
        List<Map<String, Object>> typeList = new ArrayList<>();
        GoodsType[] enumConstants = GoodsType.class.getEnumConstants();
        for (int i = 0; i < enumConstants.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", enumConstants[i].getType());
            map.put("typeCode", enumConstants[i].getTypeCode());
            typeList.add(map);
        }
        if (enumConstants.length != 0) {
            return new ResultMessage(DATA_RETURN_SUCCESS, typeList);
        } else return new ResultMessage(ERROR_NO_DATA);
    }*/

    @GetMapping("/getGoodsCount")
    public CommonResult getGoodsCount(Goods goods){
        Map<String,Integer> countMap=new HashMap<>();
        Integer integer = goodsService.queryGoodsCount(goods);
        countMap.put("GoodsCount",integer);
        return CommonResult.success(countMap,"获取购物车中商品数量成功");
    }
}
