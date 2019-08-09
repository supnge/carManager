package com.carManager.servlet.hetong;


import com.carManager.service.THeTongService;
import com.carManager.service.impl.THeTongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteAllContractServlet")
public class DeleteAllContractServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        THeTongService tHeTongService = new THeTongServiceImpl();

        String contractIds = req.getParameter("ids");
        System.out.println("删除的合同为："+contractIds);

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            //删除：
            tHeTongService.deleteAllContracts(contractIds);

            req.setAttribute("contractPageResult", tHeTongService.findContractsWithPageCount(Integer.parseInt(page)));
            req.getRequestDispatcher("/admin/products/contractList.jsp").forward(req, resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
