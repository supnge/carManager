package com.carManager.service;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChuche;

import java.sql.SQLException;

public interface TChuCheService {

    public PageResult<TChuche> findRecordsWithPageCount(int page) throws SQLException;

    public TChuche findRecordsByRecordId(int id) throws SQLException;

    public TChuche findRecordsByCarId(int id) throws SQLException;

    public int updateRecord(TChuche tChuche) throws SQLException;

    public PageResult<TChuche>  searchRecordByCondition(String cheId, String start1, String start2, String end1, String end2, int page) throws SQLException;

    public int insertRecord(TChuche tChuche) throws SQLException;

    public int deleteRecordById(int id) throws SQLException;

    public void deleteAllRecords(String ids) throws SQLException;
}
