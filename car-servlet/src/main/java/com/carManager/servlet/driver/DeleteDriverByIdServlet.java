package com.carManager.servlet.driver;

import com.carManager.domain.PageResult;
import com.carManager.domain.TSiji;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TSijiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteDriverByIdServlet")
public class DeleteDriverByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TSijiService tSijiService = new TSijiServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            tSijiService.deleteDriverById(Integer.parseInt(id));
            //跳转
            PageResult<TSiji> pageResult = tSijiService.findDriversWithPageCount(Integer.parseInt(page));

            DriverPageResultUtils.forwardToListPage(pageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
