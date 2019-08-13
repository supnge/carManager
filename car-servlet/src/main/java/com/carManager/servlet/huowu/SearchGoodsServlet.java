package com.carManager.servlet.huowu;

import com.carManager.domain.PageResult;
import com.carManager.domain.THuowu;
import com.carManager.service.THuoWuService;
import com.carManager.service.impl.THuoWuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SearchGoodsServlet")
public class SearchGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        THuoWuService tHuoWuService = new THuoWuServiceImpl();
        String name = req.getParameter("name");
        String danjia = req.getParameter("danjia");
        String carId = req.getParameter("carId");
        String carZaizhong = req.getParameter("carZaizhong");
        String zongjia = req.getParameter("zongjia");
        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {

            PageResult<THuowu> goodsPageResult = tHuoWuService.searchGoodByCondition( name,  danjia,  carId, carZaizhong, zongjia, Integer.parseInt(page));

            GoodsPageResultUtils.forwardToListPage(goodsPageResult, req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
