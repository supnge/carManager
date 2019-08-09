package com.carManager.servlet.che;


import com.carManager.service.TCheService;
import com.carManager.service.impl.TCheServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteCarByIdServlet")
public class DeleteCarByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TCheService tCheService = new TCheServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            tCheService.deleteCarById(Integer.parseInt(id));
            //跳转
            req.setAttribute("carPageResult", tCheService.findCarsWithPageCount(Integer.parseInt(page)));
            req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
