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

@WebServlet("/UpdateDriverServlet")
public class UpdateDriverServlet extends HttpServlet {
    TSijiService tSijiService = new TSijiServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String tel = req.getParameter("tel");
        String address = req.getParameter("address");
        String card = req.getParameter("card");
        String oilCard = req.getParameter("oilCard");
        String del = req.getParameter("del");

        TSiji tSiji = new TSiji(Integer.parseInt(id), name, sex, age, tel, address, card, oilCard, del);

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            tSijiService.updateDriver(tSiji);

            //跳转
            PageResult<TSiji> pageResult = tSijiService.findDriversWithPageCount(Integer.parseInt(page));

            DriverPageResultUtils.forwardToListPage(pageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
