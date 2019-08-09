package com.carManager.service.impl;

import com.carManager.dao.THuoWuDao;
import com.carManager.dao.impl.THuoWuDaoImpl;
import com.carManager.domain.PageResult;
import com.carManager.domain.THuowu;
import com.carManager.service.THuoWuService;

import java.sql.SQLException;

public class THuoWuServiceImpl implements THuoWuService {
    THuoWuDao tHuoWuDao = new THuoWuDaoImpl();

    @Override
    public PageResult<THuowu> findGoodsWithPageCount(int page) throws SQLException {
        return tHuoWuDao.findGoodsWithPageCount(page);
    }

    @Override
    public THuowu findGoodsByGoodId(int id) throws SQLException {
        return tHuoWuDao.findGoodsByGoodId(id);
    }

    @Override
    public THuowu findGoodsByCarId(int id) throws SQLException {
        return tHuoWuDao.findGoodsByCarId(id);
    }

    @Override
    public int updateGood(THuowu tHuowu) throws SQLException {
        return tHuoWuDao.updateGood(tHuowu);
    }

    @Override
    public PageResult<THuowu> searchGoodByCondition(String name, String danjia, String carId, String carZaizhong, String zongjia, int page) throws SQLException {
        return tHuoWuDao.searchGoodByCondition( name,  danjia,  carId,  carZaizhong,  zongjia,  page);
    }

    @Override
    public int insertGood(THuowu tHuowu) throws SQLException {
        return tHuoWuDao.insertGood(tHuowu);
    }

    @Override
    public int deleteGoodById(int id) throws SQLException {
        return tHuoWuDao.deleteGoodById(id);
    }

    @Override
    public void deleteAllGoods(String ids) throws SQLException {
        if(!"".equals(ids)&& ids !=null){
            String[] idArray = ids.split(",");

            for(String id: idArray){
                this.deleteGoodById(Integer.parseInt(id));
            }
        }
    }


}
