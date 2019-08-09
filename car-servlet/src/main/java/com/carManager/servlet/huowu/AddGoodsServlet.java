package com.carManager.servlet.huowu;

import com.carManager.domain.PageResult;
import com.carManager.domain.THuowu;
import com.carManager.service.THuoWuService;
import com.carManager.service.impl.THuoWuServiceImpl;
import com.carManager.utils.DateUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        THuoWuService tHuoWuService = new THuoWuServiceImpl();

        THuowu tHuowu = new THuowu();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tHuowu, req.getParameterMap());

            // 新增时放入两个时间 ：
            tHuowu.setInsertDate(DateUtils.dataFormat());
            tHuowu.setUpdateDate(DateUtils.dataFormat());

            tHuoWuService.insertGood(tHuowu);

            PageResult<THuowu> pageResult = tHuoWuService.findGoodsWithPageCount(Integer.parseInt(page));

            if (pageResult != null) {

                req.setAttribute("goodsPageResult", pageResult);
                req.getRequestDispatcher("/admin/products/goodsList.jsp").forward(req, resp);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
