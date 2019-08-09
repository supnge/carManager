package com.carManager.servlet.che;

import com.carManager.domain.TChe;
import com.carManager.domain.TSiji;
import com.carManager.service.TCheService;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TSijiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/FindCarByIdServlet")
public class FindCarByIdServlet extends HttpServlet {
    TCheService tCheService = new TCheServiceImpl();
    TSijiService tSijiService = new TSijiServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");


        //根据ID进行查询
        TChe tChe = new TChe();
        try {
            tChe = tCheService.findCarById(Integer.parseInt(id));
            req.setAttribute("car", tChe);
            req.setAttribute("driverList", tSijiService.findAllDrivers());
            req.getRequestDispatcher("/admin/products/carEdit.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
