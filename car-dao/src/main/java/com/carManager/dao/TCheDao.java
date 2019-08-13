package com.carManager.dao;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;

import java.sql.SQLException;
import java.util.List;

public interface TCheDao {



    public List<TChe> findAllCars() throws SQLException;

    public PageResult<TChe> findCarsWithPageCount(int page) throws SQLException;

    public TChe findCarsByCarId(int id) throws SQLException;

    public TChe findCarsByDriverId(int id) throws SQLException;

    public int updateCar(TChe tSiji) throws SQLException;

    public PageResult<TChe>  searchCarByCondition(String name, String sex, String tel, String oilCard, int page) throws SQLException;

    public int insertCar(TChe tSiji) throws SQLException;

    public int deleteCarById(int id) throws SQLException;
}
