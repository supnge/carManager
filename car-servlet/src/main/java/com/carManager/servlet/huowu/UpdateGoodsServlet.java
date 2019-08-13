package com.carManager.servlet.huowu;


import com.carManager.domain.PageResult;
import com.carManager.domain.THuowu;
import com.carManager.service.THuoWuService;
import com.carManager.service.impl.THuoWuServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/UpdateGoodsServlet")
public class UpdateGoodsServlet extends HttpServlet {
    THuoWuService tHuoWuService = new THuoWuServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        THuowu tHuowu = new THuowu();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {

            BeanUtils.populate(tHuowu, req.getParameterMap());

            tHuoWuService.updateGood(tHuowu);
            PageResult<THuowu> goodsPageResult = tHuoWuService.findGoodsWithPageCount(Integer.parseInt(page));
            GoodsPageResultUtils.forwardToListPage(goodsPageResult, req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
