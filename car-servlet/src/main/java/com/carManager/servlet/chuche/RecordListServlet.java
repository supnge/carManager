package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChuche;
import com.carManager.service.TCheService;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TChuCheServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

@WebServlet("/RecordListServlet")
public class RecordListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询
        TChuCheService tChuCheService = new TChuCheServiceImpl();
        TCheService tCheService = new TCheServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        //分页查询数据：
        try {
            PageResult<TChuche> recordPageResult = tChuCheService.findRecordsWithPageCount(Integer.parseInt(page));

            if (recordPageResult != null) {
                for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
                    TChuche tChuche = (TChuche)iterator.next();
                    tChuche.setChepai(tCheService.findCarById(tChuche.getCheId()).getChepai());
                }
                req.setAttribute("recordPageResult", recordPageResult);
                req.getRequestDispatcher("/admin/products/recordList.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
