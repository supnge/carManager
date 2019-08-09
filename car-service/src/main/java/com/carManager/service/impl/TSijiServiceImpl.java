package com.carManager.service.impl;

import com.carManager.dao.TSijiDao;
import com.carManager.dao.impl.TSijiDaoImpl;
import com.carManager.domain.PageResult;
import com.carManager.domain.TSiji;
import com.carManager.service.TSijiService;

import java.sql.SQLException;
import java.util.List;

public class TSijiServiceImpl implements TSijiService {
    TSijiDao tSijiDao = new TSijiDaoImpl();

    @Override
    public List<TSiji> findAllDrivers() throws SQLException {
        return tSijiDao.findAllDrivers();
    }

    @Override
    public PageResult<TSiji> findDriversWithPageCount(int page) throws SQLException {
        return tSijiDao.findDriversWithPageCount(page);
    }

    @Override
    public TSiji findSijiById(int id) throws SQLException {
        return tSijiDao.findDriversById(id);
    }

    @Override
    public int updateDriver(TSiji tSiji) throws SQLException {
        return tSijiDao.updateDriver(tSiji);
    }

    @Override
    public PageResult<TSiji> searchDriverByCondition(String name, String sex, String tel,String oilCard,  int page) throws SQLException {
        return tSijiDao.searchDriverByCondition(name, sex, tel,oilCard,  page);
    }

    @Override
    public int insertDriver(TSiji tSiji) throws SQLException {
        return tSijiDao.insertDriver(tSiji);
    }

    @Override
    public int deleteDriverById(int id) throws SQLException {
        return tSijiDao.deleteDriverById(id);
    }

    @Override
    public void deleteAllDrivers(String ids) throws SQLException {
        if(!"".equals(ids)&& ids !=null){
            String[] idArray = ids.split(",");

            for(String id: idArray){
                this.deleteDriverById(Integer.parseInt(id));
            }
        }
    }
}
