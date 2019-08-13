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

@WebServlet("/SearchDriverServlet")
public class SearchDriverServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TSijiService tSijiService = new TSijiServiceImpl();
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String oilCard = req.getParameter("oilCard");

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            PageResult<TSiji> pageResult = tSijiService.searchDriverByCondition(name, sex, tel,oilCard, Integer.parseInt(page));
            req.setAttribute("nameList",DriverUtils.removeDuplicateValues(DriverUtils.getAttr(pageResult.getList(), "name")));
            req.setAttribute("telList",DriverUtils.removeDuplicateValues(DriverUtils.getAttr(pageResult.getList(), "tel")));
            req.setAttribute("oilCardList",DriverUtils.removeDuplicateValues(DriverUtils.getAttr(pageResult.getList(), "oilCard")));

            req.setAttribute("pageResult", pageResult);
            req.getRequestDispatcher("/admin/products/driverList.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
