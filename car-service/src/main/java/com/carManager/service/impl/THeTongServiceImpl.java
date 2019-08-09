package com.carManager.service.impl;

import com.carManager.dao.THeTongDao;
import com.carManager.dao.impl.THeTongDaoImpl;
import com.carManager.domain.PageResult;
import com.carManager.domain.THetong;
import com.carManager.service.THeTongService;

import java.sql.SQLException;

public class THeTongServiceImpl implements THeTongService {
    THeTongDao tHeTongDao = new THeTongDaoImpl();

    @Override
    public PageResult<THetong> findContractsWithPageCount(int page) throws SQLException {
        return tHeTongDao.findContractsWithPageCount(page);
    }

    @Override
    public THetong findContractsById(int id) throws SQLException {
        return tHeTongDao.findContractsById(id);
    }

    @Override
    public THetong findContractsByCarId(int id) throws SQLException {
        return tHeTongDao.findContractsByCarId(id);
    }

    @Override
    public int updateContract(THetong tHetong) throws SQLException {
        return tHeTongDao.updateContract(tHetong);
    }

    @Override
    public PageResult<THetong> searchContractByCondition(String cheId, String name, String photoId, String huowuId, int page) throws SQLException {
        return tHeTongDao.searchContractByCondition(cheId, name, photoId, huowuId, page);
    }

    @Override
    public int insertContract(THetong tHetong) throws SQLException {
        return tHeTongDao.insertContract(tHetong);
    }

    @Override
    public int deleteContractById(int id) throws SQLException {
        return tHeTongDao.deleteContractById(id);
    }

    @Override
    public void deleteAllContracts(String ids) throws SQLException {
        if(!"".equals(ids)&& ids !=null){
            String[] idArray = ids.split(",");

            for(String id: idArray){
                this.deleteContractById(Integer.parseInt(id));
            }
        }
    }
}
