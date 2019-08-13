package com.carManager.servlet.huowu;

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
import java.util.List;

@WebServlet("/GoodsAddServlet")
public class GoodsAddServlet extends HttpServlet {
    // 返回车辆信息
    TCheService tCheService = new TCheServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<TChe> tCheList = tCheService.findAllCars();
            req.setAttribute("tCheList", tCheList);
            req.getRequestDispatcher("/admin/products/goodsAdd.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
