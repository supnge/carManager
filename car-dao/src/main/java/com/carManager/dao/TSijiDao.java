package com.carManager.dao;

import com.carManager.domain.PageResult;
import com.carManager.domain.TSiji;
import org.apache.ibatis.session.SqlSessionException;

import java.sql.SQLException;
import java.util.List;

public interface TSijiDao {

    public List<TSiji> findAllDrivers() throws SQLException;

    public PageResult<TSiji> findDriversWithPageCount(int page) throws SQLException;

    public TSiji findDriversById(int id) throws SQLException;

    public int updateDriver(TSiji tSiji) throws SQLException;

    public PageResult<TSiji>  searchDriverByCondition(String name, String sex, String tel,String oilCard, int page) throws SQLException;

    public int insertDriver(TSiji tSiji) throws SQLException;

    public int deleteDriverById(int id) throws SQLException;
}
