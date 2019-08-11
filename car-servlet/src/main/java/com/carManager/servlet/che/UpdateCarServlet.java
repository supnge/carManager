package com.carManager.servlet.che;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.TSiji;
import com.carManager.service.TCheService;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TSijiServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;

@WebServlet("/UpdateCarServlet")
public class UpdateCarServlet extends HttpServlet {
    TCheService tCheService = new TCheServiceImpl();
    TSijiService tSijiService = new TSijiServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        TChe tChe = new TChe();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tChe, req.getParameterMap());
            tChe.setDriverName(tSijiService.findSijiById(tChe.getSijiId()).getName());

            tCheService.updateCar(tChe);

            PageResult<TChe> tChePageResult = tCheService.findCarsWithPageCount(Integer.parseInt(page));

            if (tChePageResult != null) {
                for (Iterator iterator = tChePageResult.getList().iterator(); iterator.hasNext(); ) {
                    TChe tChe1 = (TChe) iterator.next();
                    tChe1.setDriverName(tSijiService.findSijiById(tChe1.getSijiId()).getName());
                }

                //跳转
                req.setAttribute("carPageResult", tChePageResult);
                req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
