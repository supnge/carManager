package com.carManager.servlet.che;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.service.TCheService;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TSijiServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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


        //分页查询数据：
        try {
            PageResult<TChe> carPageResult = tCheService.findCarsWithPageCount(Integer.parseInt(page));

            if (carPageResult != null) {

                //todo 可以做优化
                List<TChe> list = carPageResult.getList();
                for(Iterator iterator = list.iterator(); iterator.hasNext();){
                    TChe tChe = (TChe)iterator.next();
                    String name = tSijiService.findSijiById(tChe.getSijiId()).getName();
                    tChe.setDriverName(name);
                }

                req.setAttribute("carPageResult", carPageResult);
                req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
