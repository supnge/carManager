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

@WebServlet("/ContractListServlet")
public class ContractListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询
        THeTongService tHeTongService = new THeTongServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        //分页查询数据：
        try {
            PageResult<THetong> contractPageResult = tHeTongService.findContractsWithPageCount(Integer.parseInt(page));

            if (contractPageResult != null) {

                req.setAttribute("contractPageResult", contractPageResult);
                req.getRequestDispatcher("/admin/products/contractList.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
