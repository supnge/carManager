package com.carManager.servlet.che;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.service.TCheService;
import com.carManager.service.impl.TCheServiceImpl;
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

@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TCheService tCheService = new TCheServiceImpl();

        TChe tChe = new TChe();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tChe, req.getParameterMap());

            // 新增时放入两个时间 ：
            tChe.setInsertDate(DateUtils.dataFormat());
            tChe.setUpdateDate(DateUtils.dataFormat());

            tCheService.insertCar(tChe);

            PageResult<TChe> carPageResult = tCheService.findCarsWithPageCount(Integer.parseInt(page));

            if (carPageResult != null) {

                req.setAttribute("carPageResult", CarPageResultUtils.putDriverName(carPageResult));
                req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);
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
