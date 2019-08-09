package com.carManager.service;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;

import java.sql.SQLException;
import java.util.List;

public interface TCheService {

    public List<TChe> findAllCars() throws SQLException;
    public PageResult<TChe> findCarsWithPageCount(int page) throws SQLException;
    public TChe findCarById(int id) throws SQLException;
    public int updateCar(TChe TChe) throws SQLException;
    public PageResult<TChe> searchCarByCondition(String name, String sex, String tel, String oilCard, int page) throws SQLException;
    public int insertCar(TChe TChe) throws SQLException;
    public int deleteCarById(int id) throws SQLException;
    public void deleteAllCars(String ids) throws SQLException;

}
