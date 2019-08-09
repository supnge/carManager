package com.carManager.dao.impl;

import com.carManager.dao.TChuCheDao;
import com.carManager.domain.PageResult;
import com.carManager.domain.TChuche;
import com.carManager.utils.DateUtils;
import com.carManager.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TChuCheDaoImpl implements TChuCheDao {
    @Override
    public PageResult<TChuche> findRecordsWithPageCount(int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        PageResult<TChuche> pageResult = new PageResult<>();

        //设置当前码
        pageResult.setCurrentPage(page);
        //总条数
        List<TChuche> chuches = queryRunner.query("select * from t_chuche where 1=1 "+"and del='1' ", new BeanListHandler<>(TChuche.class));

        pageResult.putMessage(pageResult, chuches);
        /*
        // 进行改造：
        int totalCount = chuches.size();
        pageResult.setTotalCount(totalCount);
        //总页数
        int totalPageCount = (totalCount%pageResult.getPageCount()==0? totalCount/pageResult.getPageCount():totalCount/pageResult.getPageCount()+1);
        pageResult.setTotalPage(totalPageCount);
        */
        //设置当前查询到的数据
        String sql = "select * from t_chuche where 1=1 and del='1' order by id limit ?, ? ";
        int start = pageResult.getPageCount()*(page-1);
        List<TChuche> list = queryRunner.query(sql, new BeanListHandler<>(TChuche.class), start, pageResult.getPageCount());
        /*
        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            TChuche book = (TChuche) iterator.next();
        }*/

        pageResult.setList(list);

        return pageResult;
    }

    @Override
    public TChuche findRecordsByRecordId(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_chuche where id=? and del='1' ", new BeanHandler<>(TChuche.class), id);
    }

    @Override
    public TChuche findRecordsByCarId(int cheId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_chuche where cheId=? and del='1' ", new BeanHandler<>(TChuche.class), cheId);
    }

    @Override
    public int updateRecord(TChuche tChuche) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        //设置更新日期
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String updateDate = sp.format(new Date());

        int result = queryRunner.update("update t_chuche set cheId = ?, kaichushijian=?, huilaishijian=?, qishidizhi=?, mudidizhi=?, " +
                        "shiyou=?,  updateDate=? where id=? and del='1' ",
                tChuche.getCheId(), tChuche.getKaichushijian(), tChuche.getHuilaishijian(), tChuche.getQishidizhi(), tChuche.getMudidizhi(),
                tChuche.getShiyou(), updateDate, tChuche.getId());
        System.out.println("更新编号为："+ tChuche.getCheId() +"的车出车记录，更新结果为："+ result);
        return result;
    }

    /**
     * 后续考虑增加时间段查询
     * @param cheId
     * @return
     * @throws SQLException
     */
    @Override
    public PageResult<TChuche>  searchRecordByCondition(String cheId, String start1, String start2, String end1, String end2, int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        //设置当前码
        PageResult<TChuche> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);

        String sql = "select * from t_chuche where 1=1 and del='1' ";
        sql = DbUtils.conditionSearch(sql, cheId, "cheId");
        sql = DbUtils.conditionSearch(sql, "kaichushijian", start1, start2);
        sql = DbUtils.conditionSearch(sql, "huilaishijian", end1, end2);

        List<TChuche> list = queryRunner.query(sql, new BeanListHandler<>(TChuche.class) );

        pageResult.putMessage(pageResult, list);

        return pageResult;
    }

    @Override
    public int insertRecord(TChuche tChuche) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        int result = queryRunner.update("insert into t_chuche (cheId, kaichushijian, huilaishijian, qishidizhi, mudidizhi, shiyou,insertDate, updateDate, del) " +
                        "values(?,?,?,?,?,?, ?,?,?)",
                tChuche.getCheId(), tChuche.getKaichushijian(), tChuche.getHuilaishijian(), tChuche.getQishidizhi(),
                tChuche.getMudidizhi(), tChuche.getShiyou(), DateUtils.dataFormat(), DateUtils.dataFormat(),
                tChuche.getDel());
        System.out.println("新增数据为："+ tChuche.getCheId());
        return result;
    }

    /**
     * 虽然是删除功能，但只是更新数据，不在界面上进行展示，数据依然留存
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteRecordById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        // 删除时间
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String delDate = sp.format(new Date());

        int result = queryRunner.update("update t_chuche set del= '2', deleteDate=? where id =?", delDate, id);

        System.out.println(1==result? "删除编号为："+id+" 成功": "删除编号为："+id+" 失败");

        return result;
    }
}
