package com.carManager.service.impl;

import com.carManager.dao.TCheDao;
import com.carManager.dao.impl.TCheDaoImpl;
import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.service.TCheService;
import com.carManager.service.TCheService;

import java.sql.SQLException;
import java.util.List;

public class TCheServiceImpl implements TCheService {

    TCheDao TCheDao = new TCheDaoImpl();

    @Override
    public List<TChe> findAllCars() throws SQLException {
        return TCheDao.findAllCars();
    }

    @Override
    public PageResult<TChe> findCarsWithPageCount(int page) throws SQLException {
        return TCheDao.findCarsWithPageCount(page);
    }

    @Override
    public TChe findCarById(int id) throws SQLException {
        return TCheDao.findCarsByCarId(id);
    }

    @Override
    public int updateCar(TChe TChe) throws SQLException {
        return TCheDao.updateCar(TChe);
    }

    @Override
    public PageResult<TChe> searchCarByCondition(String name, String sex, String tel,String oilCard,  int page) throws SQLException {
        return TCheDao.searchCarByCondition(name, sex, tel,oilCard,  page);
    }

    @Override
    public int insertCar(TChe tChe) throws SQLException {
        return TCheDao.insertCar(tChe);
    }

    @Override
    public int deleteCarById(int id) throws SQLException {
        return TCheDao.deleteCarById(id);
    }

    @Override
    public void deleteAllCars(String ids) throws SQLException {
        if(!"".equals(ids)&& ids !=null){
            String[] idArray = ids.split(",");

            for(String id: idArray){
                this.deleteCarById(Integer.parseInt(id));
            }
        }
    }
}
