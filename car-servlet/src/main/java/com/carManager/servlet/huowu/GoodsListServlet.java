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

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询
        THuoWuService tHuoWuService = new THuoWuServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        //分页查询数据：
        try {
            PageResult<THuowu> goodsPageResult = tHuoWuService.findGoodsWithPageCount(Integer.parseInt(page));

            GoodsPageResultUtils.forwardToListPage(goodsPageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
