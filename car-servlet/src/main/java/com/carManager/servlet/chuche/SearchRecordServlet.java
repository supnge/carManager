package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.TChuche;
import com.carManager.service.TCheService;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TChuCheServiceImpl;
import com.carManager.servlet.che.CarUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/SearchRecordServlet")
public class SearchRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TChuCheService tChuCheService = new TChuCheServiceImpl();
        TCheService tCheService = new TCheServiceImpl();

        String cheId = req.getParameter("cheId");
        String start1 = req.getParameter("start1");
        String start2 = req.getParameter("start2");
        String end1 = req.getParameter("end1");
        String end2 = req.getParameter("end2");
        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }
        List<TChe> carList = new ArrayList<>();

        try {
            PageResult<TChuche> recordPageResult = tChuCheService.searchRecordByCondition(cheId, start1, start2, end1, end2, Integer.parseInt(page));

            RecordPageResultUtils.forwardToListPage(recordPageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
