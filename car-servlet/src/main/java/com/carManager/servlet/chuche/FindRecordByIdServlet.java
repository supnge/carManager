package com.carManager.servlet.chuche;


import com.carManager.domain.TChe;
import com.carManager.domain.TChuche;
import com.carManager.service.TCheService;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TChuCheServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/FindRecordByIdServlet")
public class FindRecordByIdServlet extends HttpServlet {
    TChuCheService tChuCheService = new TChuCheServiceImpl();
    TCheService tCheService = new TCheServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //根据ID进行查询
        TChuche tSiji = new TChuche();

        try {
            tSiji= tChuCheService.findRecordsByRecordId(Integer.parseInt(id));
            req.setAttribute("record", tSiji);
            List<TChe> carList = tCheService.findAllCars();
            req.setAttribute("carList", carList);
            req.getRequestDispatcher("/admin/products/recordEdit.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
