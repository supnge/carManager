package com.carManager.dao.impl;

import com.carManager.dao.THuoWuDao;
import com.carManager.domain.PageResult;
import com.carManager.domain.THuowu;
import com.carManager.utils.DateUtils;
import com.carManager.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class THuoWuDaoImpl implements THuoWuDao {

    @Override
    public List<THuowu> findAllHuowu() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        List<THuowu> huowus = queryRunner.query("select * from t_huowu where 1=1 " + "and del='1' ", new BeanListHandler<>(THuowu.class));
        return huowus;
    }

    @Override
    public PageResult<THuowu> findGoodsWithPageCount(int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        PageResult<THuowu> pageResult = new PageResult<>();

        //设置当前码
        pageResult.setCurrentPage(page);
        //总条数
        List<THuowu> huowus = queryRunner.query("select * from t_huowu where 1=1 " + "and del='1' ", new BeanListHandler<>(THuowu.class));
        /*
        int totalCount = huowus.size();
        pageResult.setTotalCount(totalCount);
        //总页数
        int totalPageCount = (totalCount%pageResult.getPageCount()==0? totalCount/pageResult.getPageCount():totalCount/pageResult.getPageCount()+1);
        pageResult.setTotalPage(totalPageCount);
        */
        pageResult.putMessage(pageResult, huowus);

        //设置当前查询到的数据
        String sql = "select * from t_huowu where 1=1 and del='1' order by id limit ?, ? ";
        int start = pageResult.getPageCount() * (page - 1);
        List<THuowu> list = queryRunner.query(sql, new BeanListHandler<>(THuowu.class), start, pageResult.getPageCount());

        pageResult.setList(list);

        return pageResult;
    }

    @Override
    public THuowu findGoodsByGoodId(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_huowu where id=? and del='1' ", new BeanHandler<>(THuowu.class), id);
    }

    @Override
    public THuowu findGoodsByCarId(int sijiId) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_huowu where cheId=? and del='1' ", new BeanHandler<>(THuowu.class), sijiId);
    }

    @Override
    public int updateGood(THuowu tHuowu) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        //设置更新日期
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String updateDate = sp.format(new Date());

        int result = queryRunner.update("update t_huowu set name = ?, danjia=?, carId=?, carZaizhong=?, zongjia=?, remark=?, updateDate=? where id=? and del='1' ",
                tHuowu.getName(), tHuowu.getDanjia(), tHuowu.getCarId(), tHuowu.getCarZaizhong(), tHuowu.getZongjia(), tHuowu.getRemark(), updateDate, tHuowu.getId());
        System.out.println("更新对象为：" + tHuowu.getName() + "更新结果为：" + result);
        return result;
    }

    @Override
    public PageResult<THuowu> searchGoodByCondition(String name, String danjia, String carId, String carZaizhong, String zongjia, int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        //设置当前码
        PageResult<THuowu> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);

        //TODO : 后期需要修改 按价格区间进行查找
        String sql = "select * from t_huowu where 1=1 and del='1' ";
        sql = DbUtils.conditionSearch(sql, name, "name");
        sql = DbUtils.conditionSearch(sql, danjia, "danjia");
        sql = DbUtils.conditionSearch(sql, carId, "carId");
        sql = DbUtils.conditionSearch(sql, carZaizhong, "carZaizhong");
        sql = DbUtils.conditionSearch(sql, zongjia, "zongjia");

        List<THuowu> list = queryRunner.query(sql, new BeanListHandler<>(THuowu.class));

        pageResult.putMessage(pageResult, list);

        return pageResult;
    }

    @Override
    public int insertGood(THuowu tHuowu) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        int result = queryRunner.update("insert into t_huowu (name, danjia, carId,carZaizhong, zongjia, insertDate, updateDate, remark, del) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                tHuowu.getName(), tHuowu.getDanjia(), tHuowu.getCarId(), tHuowu.getCarZaizhong(), tHuowu.getZongjia(),
                DateUtils.dataFormat(), DateUtils.dataFormat(), tHuowu.getRemark(), tHuowu.getDel());
        System.out.println("新增数据为：" + tHuowu.getName());
        return result;
    }

    /**
     * 虽然是删除功能，但只是更新数据，不在界面上进行展示，数据依然留存
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteGoodById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        // 删除时间
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String delDate = sp.format(new Date());

        int result = queryRunner.update("update t_huowu set del= 2, deleteDate=? where id =?", delDate, id);

        System.out.println(1 == result ? "删除编号为：" + id + " 成功" : "删除编号为：" + id + " 失败");

        return result;
    }
}
