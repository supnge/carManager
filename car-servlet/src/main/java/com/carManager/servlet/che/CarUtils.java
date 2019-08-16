package com.carManager.servlet.che;

import com.carManager.domain.*;
import com.carManager.service.TCheService;
import com.carManager.service.impl.TCheServiceImpl;

import java.sql.SQLException;
import java.util.*;

public class CarUtils {

    // 给出车记录添加车牌信息
    public static PageResult<TChuche> addRecordsChepai(PageResult<TChuche> recordPageResult) throws SQLException {
        TCheService tCheService = new TCheServiceImpl();
        for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
            TChuche tChuche = (TChuche)iterator.next();
            tChuche.setChepai(tCheService.findCarById(tChuche.getCheId()).getChepai());
        }
        return recordPageResult;
    }

    // 给货物添加车牌信息
    public static PageResult<THuowu> addGoodsChepai(PageResult<THuowu> recordPageResult) throws SQLException {
        TCheService tCheService = new TCheServiceImpl();
        for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
            THuowu tHuowu = (THuowu) iterator.next();
            tHuowu.setChepai(tCheService.findCarById(tHuowu.getCarId()).getChepai());
        }
        return recordPageResult;
    }

    // 给合同添加车牌信息
    public static PageResult<THetong> addContractChepai(PageResult<THetong> recordPageResult) throws SQLException {
        TCheService tCheService = new TCheServiceImpl();
        for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
            THetong tHetong = (THetong) iterator.next();
            tHetong.setChepai(tCheService.findCarById(tHetong.getCheId()).getChepai());
        }
        return recordPageResult;
    }

    // 去重
    public static List<TChe> removeRecordsDuplicateCar(PageResult<TChuche> recordPageResult, List<TChe> carList) throws SQLException {
        TCheService tCheService = new TCheServiceImpl();

        // 获取车辆列表
        for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
            TChuche tChuche = (TChuche)iterator.next();
            TChe tChe = tCheService.findCarById(tChuche.getCheId());
            carList.add(tChe);
        }

        // 根据车id去重
        Set<TChe> cheSet = new TreeSet<>(Comparator.comparing(TChe::getId));

        cheSet.addAll(carList);
        List<TChe> cheIdInRecord= new ArrayList<>(cheSet);

        return cheIdInRecord;
    }

    // 去重
    public static List<TChe> removeGoodsDuplicateCar(PageResult<THuowu> recordPageResult, List<TChe> carList) throws SQLException {
        TCheService tCheService = new TCheServiceImpl();

        // 获取车辆列表
        for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
            THuowu tHuowu = (THuowu) iterator.next();
            TChe tChe = tCheService.findCarById(tHuowu.getCarId());
            carList.add(tChe);
        }

        // 根据车id去重
        Set<TChe> cheSet = new TreeSet<>(Comparator.comparing(TChe::getId));

        cheSet.addAll(carList);
        List<TChe> cheIdInRecord= new ArrayList<>(cheSet);

        return cheIdInRecord;
    }

    // 合同中的车辆信息
    public static List<TChe> removeContractDuplicateCar(PageResult<THetong> recordPageResult, List<TChe> carList) throws SQLException {
        TCheService tCheService = new TCheServiceImpl();

        // 获取车辆列表
        for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
            THetong tHetong = (THetong) iterator.next();
            TChe tChe = tCheService.findCarById(tHetong.getCheId());
            carList.add(tChe);
        }

        // 根据车id去重
        Set<TChe> cheSet = new TreeSet<>(Comparator.comparing(TChe::getId));

        cheSet.addAll(carList);
        List<TChe> cheIdInRecord= new ArrayList<>(cheSet);

        return cheIdInRecord;
    }
}
