package com.carManager.servlet.driver;

import com.carManager.domain.PageResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DriverPageResultUtils {
    //  通过 SijiId 查询name  并回填到pageResult中对应的字段
    public static void forwardToListPage(PageResult pageResult, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        if(pageResult!=null) {
            req.setAttribute("nameList", DriverUtils.removeDuplicateValues(DriverUtils.getAttr(pageResult.getList(), "name")));
            req.setAttribute("telList", DriverUtils.removeDuplicateValues(DriverUtils.getAttr(pageResult.getList(), "tel")));
            req.setAttribute("oilCardList", DriverUtils.removeDuplicateValues(DriverUtils.getAttr(pageResult.getList(), "oilCard")));

            req.setAttribute("pageResult", pageResult);
            req.getRequestDispatcher("/admin/products/driverList.jsp").forward(req, resp);
        }
    }
}
