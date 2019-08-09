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

@WebServlet("/SearchCarServlet")
public class SearchCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TCheService tCheService = new TCheServiceImpl();

        String chepai = req.getParameter("chepai");
        String chexing = req.getParameter("chexing");
        String sijiId = req.getParameter("sijiId");
        String shiyouleixing = req.getParameter("shiyouleixing");
        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            PageResult<TChe> carPageResult = tCheService.searchCarByCondition(chepai, chexing, sijiId,shiyouleixing, Integer.parseInt(page));

            req.setAttribute("carPageResult", carPageResult);
            req.getRequestDispatcher("/admin/products/carList.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
