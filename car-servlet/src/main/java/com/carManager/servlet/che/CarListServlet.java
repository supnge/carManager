package com.carManager.servlet.che;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.TSiji;
import com.carManager.service.TCheService;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TSijiServiceImpl;
import com.carManager.servlet.driver.DriverUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/CarListServlet")
public class CarListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询
        TCheService tCheService = new TCheServiceImpl();
        TSijiService tSijiService = new TSijiServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        // 添加一个司机List
        List<TSiji> tSijiList = new ArrayList<>();

        //分页查询数据：
        try {
            PageResult<TChe> carPageResult = tCheService.findCarsWithPageCount(Integer.parseInt(page));

            if (carPageResult != null) {

                for (Iterator iterator = carPageResult.getList().iterator(); iterator.hasNext(); ) {
                    TChe tChe = (TChe) iterator.next();
                    // 查找司机Id
                    TSiji tSiji = tSijiService.findSijiById(tChe.getSijiId());
                    tSijiList.add(tSiji);
                }

                tSijiList = DriverUtils.removeDuplicateUser(tSijiList);


                req.setAttribute("tSijiList", tSijiList);
                req.setAttribute("carPageResult", CarPageResultUtils.putDriverName(carPageResult));
                req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
