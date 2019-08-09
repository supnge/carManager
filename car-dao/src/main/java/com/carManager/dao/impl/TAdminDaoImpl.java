package com.carManager.dao.impl;

import com.carManager.dao.TAdminDao;
import com.carManager.domain.TAdmin;
import com.carManager.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class TAdminDaoImpl implements TAdminDao {
    @Override
    public TAdmin findAdminById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_admin where userId=?", new BeanHandler<>(TAdmin.class), id);
    }

    @Override
    public TAdmin findAdminByConditions(String username, String passwd, String userType) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
        return queryRunner.query("select * from t_admin where userName=? and userPw=? and type=?", new BeanHandler<>(TAdmin.class), username, passwd, userType);
    }
}
