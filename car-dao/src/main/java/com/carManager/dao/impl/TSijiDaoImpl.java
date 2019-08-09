package com.carManager.dao.impl;

import com.carManager.dao.TSijiDao;
import com.carManager.domain.PageResult;
import com.carManager.domain.TSiji;
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

public class TSijiDaoImpl implements TSijiDao {
    private QueryRunner queryRunner;

    @Override
    public List<TSiji> findAllDrivers() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        List<TSiji> drivers = queryRunner.query("select * from t_siji where 1=1 "+"and del='1' ", new BeanListHandler<>(TSiji.class));
        return drivers;
    }

    @Override
    public PageResult<TSiji> findDriversWithPageCount(int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        PageResult<TSiji> pageResult = new PageResult<>();

        //设置当前码
        pageResult.setCurrentPage(page);
        //总条数
        List<TSiji> books = queryRunner.query("select * from t_siji where 1=1 "+"and del='1' ", new BeanListHandler<>(TSiji.class));
        int totalCount = books.size();
        pageResult.setTotalCount(totalCount);
        //总页数
        int totalPageCount = (totalCount%pageResult.getPageCount()==0? totalCount/pageResult.getPageCount():totalCount/pageResult.getPageCount()+1);
        pageResult.setTotalPage(totalPageCount);
        //设置当前查询到的数据
        String sql = "select * from t_siji where 1=1 and del='1' order by id limit ?, ? ";
        int start = pageResult.getPageCount()*(page-1);
        List<TSiji> list = queryRunner.query(sql, new BeanListHandler<>(TSiji.class), start, pageResult.getPageCount());

        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            TSiji book = (TSiji) iterator.next();
        }

        pageResult.setList(list);

        return pageResult;
    }

    @Override
    public TSiji findDriversById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_siji where id=? and del='1' ", new BeanHandler<>(TSiji.class), id);
    }

    @Override
    public int updateDriver(TSiji tSiji) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        //设置更新日期
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String updateDate = sp.format(new Date());

        int result = queryRunner.update("update t_siji set name = ?, sex=?, age=?, tel=?, address=?, card=?, oilCard=?, updateDate=? where id=? and del='1' ",
                tSiji.getName(), tSiji.getSex(), tSiji.getAge(), tSiji.getTel(),tSiji.getAddress(), tSiji.getCard(), tSiji.getOilCard(),updateDate, tSiji.getId());
        System.out.println("更新对象为："+ tSiji.getName() +"更新结果为："+ result);
        return result;
    }

    @Override
    public PageResult<TSiji>  searchDriverByCondition(String name, String sex, String tel,String oilCard,  int page) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        //设置当前码
        PageResult<TSiji> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);


        String sql = "select * from t_siji where 1=1 and del='1' ";
        if(!"".equals(name)){
            sql += "and name like '%"+name+"%'";
        }
        if(!"".equals(sex)){
            sql += "and sex like '%"+sex+"%'";
        }
        if(!"".equals(tel)){
            sql += "and tel like '%"+tel+"%'";
        }
        if(!"".equals(oilCard)){
            sql += "and oilCard like '%"+oilCard +"%'";
        }


        List<TSiji> list = queryRunner.query(sql, new BeanListHandler<>(TSiji.class) );

        pageResult.putMessage(pageResult, list);

        return pageResult;
    }

    @Override
    public int insertDriver(TSiji tSiji) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        int result = queryRunner.update("insert into t_siji (name, sex, age, tel, address, card, oilCard,insertDate, updateDate, del) values(?,?,?,?,?,?, ?,?,?,?)",
                tSiji.getName(),tSiji.getSex(), tSiji.getAge(),tSiji.getTel(), tSiji.getAddress(), tSiji.getCard(),
                tSiji.getOilCard(),tSiji.getInsertDate(), tSiji.getUpdateDate(), tSiji.getDel());
        System.out.println("新增司机为："+ tSiji.getName());
        return result;
    }

    /**
     * 虽然是删除功能，但只是更新数据，不在界面上进行展示，数据依然留存
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteDriverById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

        // 删除时间
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String delDate = sp.format(new Date());

        int result = queryRunner.update("update t_siji set del= 2, deleteDate=? where id =?", delDate, id);

        System.out.println(1==result? "删除编号为："+id+"的司机成功": "删除编号为："+id+"的司机失败");

        return result;
    }
}
