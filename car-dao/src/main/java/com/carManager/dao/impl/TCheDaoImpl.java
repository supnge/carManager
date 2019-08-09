package com.carManager.dao.impl;

import com.carManager.dao.TCheDao;
import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
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

public class TCheDaoImpl implements TCheDao {

    @Override
    public List<TChe> findAllCars() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        List<TChe> cars = queryRunner.query("select * from t_che where 1=1 "+"and del='1' ", new BeanListHandler<>(TChe.class));
        return cars;
    }

    @Override
    public PageResult<TChe> findCarsWithPageCount(int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        PageResult<TChe> pageResult = new PageResult<>();

        //设置当前码
        pageResult.setCurrentPage(page);
        //总条数
        List<TChe> cars = queryRunner.query("select * from t_che where 1=1 "+"and del='1' ", new BeanListHandler<>(TChe.class));

        pageResult.putMessage(pageResult, cars);

        //设置当前查询到的数据
        String sql = "select * from t_che where 1=1 and del='1' order by id limit ?, ? ";
        int start = pageResult.getPageCount()*(page-1);
        List<TChe> list = queryRunner.query(sql, new BeanListHandler<>(TChe.class), start, pageResult.getPageCount());

        pageResult.setList(list);

        return pageResult;
    }

    @Override
    public TChe findCarsByCarId(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_che where id=? and del='1' ", new BeanHandler<>(TChe.class), id);
    }

    @Override
    public TChe findCarsByDriverId(int sijiId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_che where sijiId=? and del='1' ", new BeanHandler<>(TChe.class), sijiId);
    }

    @Override
    public int updateCar(TChe tChe) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        //设置更新日期
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String updateDate = sp.format(new Date());

        int result = queryRunner.update("update t_che set chepai = ?, chexing=?, chuchangriqi=?, zaizhongliang=?, sijiId=?, " +
                        "shiyouleixing=?,  updateDate=? where id=? and del='1' ",
                tChe.getChepai(), tChe.getChexing(), tChe.getChuchangriqi(), tChe.getZaizhongliang(), tChe.getSijiId(),
                tChe.getShiyouleixing(), updateDate, tChe.getId());
        System.out.println("更新对象为："+ tChe.getChepai() +"更新结果为："+ result);
        return result;
    }

    @Override
    public PageResult<TChe>  searchCarByCondition(String chepai, String chexing, String sijiId,String shiyouleixing,  int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        //设置当前码
        PageResult<TChe> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);


        String sql = "select * from t_che where 1=1 and del='1' ";
        sql = DbUtils.conditionSearch(sql, chepai, "chepai");
        sql = DbUtils.conditionSearch(sql, chexing, "chexing");
        sql = DbUtils.conditionSearch(sql, sijiId, "sijiId");
        sql = DbUtils.conditionSearch(sql, shiyouleixing, "shiyouleixing");

        List<TChe> list = queryRunner.query(sql, new BeanListHandler<>(TChe.class) );

        pageResult.putMessage(pageResult, list);

        return pageResult;
    }

    @Override
    public int insertCar(TChe tChe) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        int result = queryRunner.update("insert into t_che (chepai, chexing, chuchangriqi, zaizhongliang, sijiId, shiyouleixing, insertDate, updateDate, del) " +
                        "values(?,?,?,?,?,?, ?,?,?)",
                tChe.getChepai(), tChe.getChexing(), tChe.getChuchangriqi(), tChe.getZaizhongliang(), tChe.getSijiId(),
                tChe.getShiyouleixing(), DateUtils.dataFormat(), DateUtils.dataFormat(), tChe.getDel());
        System.out.println("新增数据为："+ tChe.getChepai());
        return result;
    }

    /**
     * 虽然是删除功能，但只是更新数据，不在界面上进行展示，数据依然留存
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteCarById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        // 删除时间
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String delDate = sp.format(new Date());

        int result = queryRunner.update("update t_che set del= 2, deleteDate=? where id =?", delDate, id);

        System.out.println(1==result? "删除编号为："+id+" 成功": "删除编号为："+id+" 失败");

        return result;
    }
}
