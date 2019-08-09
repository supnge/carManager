package com.carManager.servlet.hetong;

import com.carManager.domain.PageResult;
import com.carManager.domain.THetong;
import com.carManager.service.THeTongService;
import com.carManager.service.impl.THeTongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SearchContractServlet")
public class SearchContractServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        THeTongService tHeTongService = new THeTongServiceImpl();
        String cheId = req.getParameter("cheId");
        String name = req.getParameter("name");
        String photoId = req.getParameter("photoId");
        String huowuId = req.getParameter("huowuId");
        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            PageResult<THetong> contractPageResult = tHeTongService.searchContractByCondition( cheId, name,  photoId,  huowuId, Integer.parseInt(page));
            req.setAttribute("contractPageResult", contractPageResult);
            req.getRequestDispatcher("/admin/products/contractList.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
