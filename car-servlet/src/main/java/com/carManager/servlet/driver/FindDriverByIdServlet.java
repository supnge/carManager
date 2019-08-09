package com.carManager.servlet.driver;

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

@WebServlet("/FindDriverByIdServlet")
public class FindDriverByIdServlet extends HttpServlet {
    TSijiService tSijiService = new TSijiServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //根据ID进行查询
        TSiji tSiji = new TSiji();
        try {
            TSiji driver= tSijiService.findSijiById(Integer.parseInt(id));
            req.setAttribute("driver", driver);
            req.getRequestDispatcher("/admin/products/driverEdit.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
