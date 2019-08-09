package com.carManager.servlet.che;

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
import java.util.HashMap;
import java.util.List;

@WebServlet("/CarAddServlet")
public class CarAddServlet extends HttpServlet {
    TSijiService tSijiService = new TSijiServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            List<TSiji> tSijiList = tSijiService.findAllDrivers();
            req.setAttribute("driverList", tSijiList);
            req.getRequestDispatcher("/admin/products/carAdd.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
