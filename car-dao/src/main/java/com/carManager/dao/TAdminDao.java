package com.carManager.dao;

import com.carManager.domain.TAdmin;

import java.sql.SQLException;

public interface TAdminDao {
    public TAdmin findAdminById(int id) throws SQLException;
    public TAdmin findAdminByConditions(String username, String passwd, String userType) throws SQLException;
}
