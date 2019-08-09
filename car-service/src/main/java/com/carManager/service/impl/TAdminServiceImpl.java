package com.carManager.service.impl;

import com.carManager.dao.TAdminDao;
import com.carManager.dao.impl.TAdminDaoImpl;
import com.carManager.domain.TAdmin;
import com.carManager.service.TAdminService;

import java.sql.SQLException;

public class TAdminServiceImpl implements TAdminService {
    @Override
    public TAdmin findAdminByConditions(String username, String passwd, String userType) throws SQLException {
        TAdminDao tAdminDao = new TAdminDaoImpl();

        return tAdminDao.findAdminByConditions(username, passwd, userType);
    }

    @Override
    public TAdmin adminLogin(TAdmin tAdmin) throws SQLException {
        TAdminDao tAdminDao = new TAdminDaoImpl();
        TAdmin tAdmin1 = tAdminDao.findAdminByConditions(tAdmin.getUsername(), tAdmin.getUserpw(), tAdmin.getType());
        return tAdmin1;
    }
}
