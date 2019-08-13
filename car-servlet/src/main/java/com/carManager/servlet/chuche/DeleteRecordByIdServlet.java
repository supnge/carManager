package com.carManager.servlet.chuche;


import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.TChuche;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TChuCheServiceImpl;
import com.carManager.servlet.che.CarUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DeleteRecordByIdServlet")
public class DeleteRecordByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        TChuCheService tChuCheService = new TChuCheServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            tChuCheService.deleteRecordById(Integer.parseInt(id));
            PageResult<TChuche> recordPageResult = tChuCheService.findRecordsWithPageCount(Integer.parseInt(page));
            RecordPageResultUtils.forwardToListPage(recordPageResult, req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
