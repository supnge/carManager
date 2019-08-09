package com.carManager.servlet.huowu;


import com.carManager.service.THuoWuService;
import com.carManager.service.impl.THuoWuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteGoodsByIdServlet")
public class DeleteGoodsByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        THuoWuService tHuoWuService = new THuoWuServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            tHuoWuService.deleteGoodById(Integer.parseInt(id));
            //跳转
            req.setAttribute("goodsPageResult", tHuoWuService.findGoodsWithPageCount(Integer.parseInt(page)));
            req.getRequestDispatcher("/admin/products/goodsList.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
