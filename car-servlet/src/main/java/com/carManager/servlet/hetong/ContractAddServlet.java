package com.carManager.servlet.hetong;

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

@WebServlet("/ContractAddServlet")
public class ContractAddServlet extends HttpServlet {
    // 返回所有的车辆记录
    TCheService tCheService = new TCheServiceImpl();
    THuoWuService tHuoWuService = new THuoWuServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<TChe> tCheList = tCheService.findAllCars();
            req.setAttribute("tCheList", tCheList);
            List<THuowu> goodsList = tHuoWuService.findAllGoods();
            req.setAttribute("goodsList", goodsList);
            req.getRequestDispatcher("/admin/products/contractAdd.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
