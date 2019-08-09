package com.carManager.servlet.che;


import com.carManager.domain.TChe;
import com.carManager.service.TCheService;
import com.carManager.service.impl.TCheServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteAllCarsServlet")
public class DeleteAllCarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TCheService tCheService = new TCheServiceImpl();

        String carids = req.getParameter("ids");
        System.out.println("删除的车辆为："+carids);

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            //删除：
            tCheService.deleteAllCars(carids);

            req.setAttribute("carPageResult", tCheService.findCarsWithPageCount(Integer.parseInt(page)));
            req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
