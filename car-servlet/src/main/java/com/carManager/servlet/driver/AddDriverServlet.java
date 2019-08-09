package com.carManager.servlet.driver;

import com.carManager.domain.PageResult;
import com.carManager.domain.TSiji;
import com.carManager.service.TSijiService;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddDriverServlet")
public class AddDriverServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TSijiService tSijiService = new TSijiServiceImpl();

        TSiji tSiji = new TSiji();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tSiji, req.getParameterMap());

            // 新增时放入两个时间 ：
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

            tSiji.setInsertDate(simpleDateFormat.format(new Date()));
            tSiji.setUpdateDate(simpleDateFormat.format(new Date()));

            tSijiService.insertDriver(tSiji);

            PageResult<TSiji> pageResult = tSijiService.findDriversWithPageCount(Integer.parseInt(page));

            if (pageResult != null) {

                req.setAttribute("pageResult", pageResult);
                req.getRequestDispatcher("/admin/products/driverList.jsp").forward(req, resp);
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
