package com.carManager.servlet.huowu;

import com.carManager.domain.*;
import com.carManager.service.TCheService;
import com.carManager.service.THuoWuService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.THuoWuServiceImpl;

import java.sql.SQLException;
import java.util.*;

public class GoodsUtils {
    // 给合同添加货物名称
    public static PageResult<THetong> addContractGoodName(PageResult<THetong> recordPageResult) throws SQLException {
        THuoWuService tHuoWuService = new THuoWuServiceImpl();
        for (Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext(); ) {
            THetong tHetong = (THetong) iterator.next();
            THuowu huowu = tHuoWuService.findGoodsByGoodId(tHetong.getHuowuId());
            if (huowu != null) {
                tHetong.setHuowuName(huowu.getName());
            } else {
                tHetong.setHuowuId(999999999);
                tHetong.setHuowuName("未关联货物信息");
            }
        }
        return recordPageResult;
    }


    // 去重
    public static List<THuowu> removeContractDuplicateGoods(PageResult<THetong> recordPageResult, List<THuowu> goodsList) throws SQLException {
        THuoWuService tHuoWuService = new THuoWuServiceImpl();

        // 获取车辆列表
        for (Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext(); ) {
            THetong tHetong = (THetong) iterator.next();
            THuowu tHuowu = tHuoWuService.findGoodsByGoodId(tHetong.getHuowuId());
            goodsList.add(tHuowu);
        }

        // 根据车id去重
        Set<THuowu> goodsSet = new TreeSet<>(Comparator.comparing(THuowu::getId));

        goodsSet.addAll(goodsList);
        List<THuowu> goodsIdInRecord = new ArrayList<>(goodsSet);

        return goodsIdInRecord;
    }
    // 添加货物名称去重
}
