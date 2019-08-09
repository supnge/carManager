package com.carManager.dao;

import com.carManager.domain.PageResult;
import com.carManager.domain.THetong;

import java.sql.SQLException;

public interface THeTongDao {

    public PageResult<THetong> findContractsWithPageCount(int page) throws SQLException;

    public THetong findContractsById(int id) throws SQLException;

    public THetong findContractsByCarId(int id) throws SQLException;

    public int updateContract(THetong tHetong) throws SQLException;

    public PageResult<THetong>  searchContractByCondition(String cheId,String name, String photoId, String huowuId, int page) throws SQLException;

    public int insertContract(THetong tHetong) throws SQLException;

    public int deleteContractById(int id) throws SQLException;
}
