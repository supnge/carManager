package com.carManager.servlet.hetong;


import com.carManager.domain.THetong;
import com.carManager.service.TChuCheService;
import com.carManager.service.THeTongService;
import com.carManager.service.impl.THeTongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/FindContractByIdServlet")
public class FindContractByIdServlet extends HttpServlet {
    THeTongService tHeTongService = new THeTongServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //根据ID进行查询
        THetong contract = new THetong();
        try {
            contract = tHeTongService.findContractsById(Integer.parseInt(id));
            req.setAttribute("contract", contract);
            req.getRequestDispatcher("/admin/products/contractEdit.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
