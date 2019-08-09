package com.carManager.servlet.huowu;

import com.carManager.service.THuoWuService;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.THuoWuServiceImpl;
import com.carManager.service.impl.TSijiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteAllGoodsServlet")
public class DeleteAllGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        THuoWuService tHuoWuService = new THuoWuServiceImpl();

        String driverids = req.getParameter("ids");
        System.out.println("删除的货物为："+driverids);

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            //删除：
            tHuoWuService.deleteAllGoods(driverids);

            req.setAttribute("goodsPageResult", tHuoWuService.findGoodsWithPageCount(Integer.parseInt(page)));
            req.getRequestDispatcher("/admin/products/goodsList.jsp").forward(req, resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
