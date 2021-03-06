package com.carManager.servlet.huowu;


import com.carManager.domain.TChe;
import com.carManager.domain.THuowu;
import com.carManager.service.TCheService;
import com.carManager.service.THuoWuService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.THuoWuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/FindGoodsByIdServlet")
public class FindGoodsByIdServlet extends HttpServlet {
    THuoWuService tHuoWuService = new THuoWuServiceImpl();
    TCheService tCheService = new TCheServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //根据ID进行查询
        THuowu goods = new THuowu();
        try {
            goods= tHuoWuService.findGoodsByGoodId(Integer.parseInt(id));
            req.setAttribute("goods", goods);
            List<TChe> carList = tCheService.findAllCars();
            req.setAttribute("carList", carList);

            req.getRequestDispatcher("/admin/products/goodsEdit.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
