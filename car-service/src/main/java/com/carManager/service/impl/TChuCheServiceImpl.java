package com.carManager.service.impl;

import com.carManager.dao.TChuCheDao;
import com.carManager.dao.impl.TChuCheDaoImpl;
import com.carManager.domain.PageResult;
import com.carManager.domain.TChuche;
import com.carManager.service.TChuCheService;

import java.sql.SQLException;

public class TChuCheServiceImpl implements TChuCheService {

    TChuCheDao tChuCheDao = new TChuCheDaoImpl();

    @Override
    public PageResult<TChuche> findRecordsWithPageCount(int page) throws SQLException {
        return tChuCheDao.findRecordsWithPageCount(page);
    }

    @Override
    public TChuche findRecordsByRecordId(int id) throws SQLException {
        return tChuCheDao.findRecordsByRecordId(id);
    }

    @Override
    public TChuche findRecordsByCarId(int id) throws SQLException {
        return tChuCheDao.findRecordsByCarId(id);
    }

    @Override
    public int updateRecord(TChuche tChuche) throws SQLException {
        return tChuCheDao.updateRecord(tChuche);
    }

    @Override
    public PageResult<TChuche> searchRecordByCondition(String cheId, String start1, String start2, String end1, String end2, int page) throws SQLException {
        return tChuCheDao.searchRecordByCondition(cheId, start1, start2, end1, end2, page);
    }

    @Override
    public int insertRecord(TChuche tChuche) throws SQLException {
        return tChuCheDao.insertRecord(tChuche);
    }

    @Override
    public int deleteRecordById(int id) throws SQLException {
        return tChuCheDao.deleteRecordById(id);
    }

    @Override
    public void deleteAllRecords(String ids) throws SQLException {
        if(!"".equals(ids)&& ids !=null){
            String[] idArray = ids.split(",");

            for(String id: idArray){
                this.deleteRecordById(Integer.parseInt(id));
            }
        }
    }


}
