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

@WebServlet("/DeleteContractByIdServlet")
public class DeleteContractByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        THeTongService tHeTongService = new THeTongServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            tHeTongService.deleteContractById(Integer.parseInt(id));
            //跳转

            PageResult<THetong> contractPageResult = tHeTongService.findContractsWithPageCount(Integer.parseInt(page));

            ContractPageResultUtils.forwardToListPage(contractPageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
