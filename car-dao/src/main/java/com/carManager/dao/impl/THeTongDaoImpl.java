package com.carManager.dao.impl;

import com.carManager.dao.THeTongDao;
import com.carManager.domain.PageResult;
import com.carManager.domain.THetong;
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

public class THeTongDaoImpl implements THeTongDao {

    @Override
    public PageResult<THetong> findContractsWithPageCount(int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        PageResult<THetong> pageResult = new PageResult<>();

        //设置当前码
        pageResult.setCurrentPage(page);
        //总条数
        List<THetong> contacts = queryRunner.query("select * from t_hetong where 1=1 "+"and del='1' ", new BeanListHandler<>(THetong.class));
        pageResult.putMessage(pageResult, contacts);

        //设置当前查询到的数据
        String sql = "select * from t_hetong where 1=1 and del='1' order by id limit ?, ? ";
        int start = pageResult.getPageCount()*(page-1);
        List<THetong> list = queryRunner.query(sql, new BeanListHandler<>(THetong.class), start, pageResult.getPageCount());

        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            THetong book = (THetong) iterator.next();
        }

        pageResult.setList(list);

        return pageResult;
    }

    @Override
    public THetong findContractsById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_hetong where id=? and del='1' ", new BeanHandler<>(THetong.class), id);
    }

    @Override
    public THetong findContractsByCarId(int heTongId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_hetong where cheId=? and del='1' ", new BeanHandler<>(THetong.class), heTongId);
    }

    @Override
    public int updateContract(THetong tHetong) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        //设置更新日期
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String updateDate = sp.format(new Date());

        int result = queryRunner.update("update t_hetong set name=?,  cheId = ?, photoId=?, huowuId=?,  updateDate=? where id=? and del='1' ",
                tHetong.getName(), tHetong.getCheId(), tHetong.getPhotoId(), tHetong.getHuowuId(),  updateDate, tHetong.getId());
        System.out.println("更新对象为："+ tHetong.getName() +"更新结果为："+ result);
        return result;
    }

    @Override
    public PageResult<THetong> searchContractByCondition(String cheId,String name, String photoId, String huowuId, int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        //设置当前码
        PageResult<THetong> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);


        String sql = "select * from t_hetong where 1=1 and del='1' ";
        sql = DbUtils.conditionSearch(sql, cheId, "cheId");
        sql = DbUtils.conditionSearch(sql, name, "name");
        sql = DbUtils.conditionSearch(sql, photoId,"photoId");
        sql = DbUtils.conditionSearch(sql, huowuId, "huowuId");

        List<THetong> list = queryRunner.query(sql, new BeanListHandler<>(THetong.class) );

        pageResult.putMessage(pageResult, list);

        return pageResult;
    }

    @Override
    public int insertContract(THetong tHetong) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        int result = queryRunner.update("insert into t_hetong (name, cheId, photoId, huowuId,insertDate, updateDate, del) " +
                        "values(?,?,?,?,?,?, ?)",
                 tHetong.getName(), tHetong.getCheId(), tHetong.getPhotoId(),
                tHetong.getHuowuId(), DateUtils.dataFormat(), DateUtils.dataFormat(), tHetong.getDel());
        System.out.println("新增数据为："+ tHetong.getName());
        return result;
    }

    /**
     * 虽然是删除功能，但只是更新数据，不在界面上进行展示，数据依然留存
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteContractById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        // 删除时间
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String delDate = sp.format(new Date());

        int result = queryRunner.update("update t_hetong set del= 2, deleteDate=? where id =?", delDate, id);

        System.out.println(1==result? "删除编号为："+id+" 成功": "删除编号为："+id+" 失败");

        return result;
    }
}
