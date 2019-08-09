package com.carManager.service;

import com.carManager.domain.TAdmin;

import java.sql.SQLException;

public interface TAdminService {
    public TAdmin findAdminByConditions(String username, String passwd, String userType) throws SQLException;
    public TAdmin adminLogin(TAdmin tAdmin) throws SQLException;
}
