package com.carManager.service;

import com.carManager.domain.PageResult;
import com.carManager.domain.THuowu;

import java.sql.SQLException;
import java.util.List;

public interface THuoWuService {

    public List<THuowu> findAllGoods() throws SQLException;

    public PageResult<THuowu> findGoodsWithPageCount(int page) throws SQLException;

    public THuowu findGoodsByGoodId(int id) throws SQLException;

    public THuowu findGoodsByCarId(int id) throws SQLException;

    public int updateGood(THuowu tHuowu) throws SQLException;

    public PageResult<THuowu>  searchGoodByCondition(String name, String danjia, String carId, String carZaizhong, String zongjia, int page) throws SQLException;

    public int insertGood(THuowu tHuowu) throws SQLException;

    public int deleteGoodById(int id) throws SQLException;

    public void deleteAllGoods(String ids) throws SQLException;
}
