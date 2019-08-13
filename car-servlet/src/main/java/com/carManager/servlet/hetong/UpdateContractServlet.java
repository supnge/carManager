package com.carManager.servlet.hetong;


import com.carManager.domain.PageResult;
import com.carManager.domain.THetong;
import com.carManager.service.THeTongService;
import com.carManager.service.impl.THeTongServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/UpdateContractServlet")
public class UpdateContractServlet extends HttpServlet {
    THeTongService tHeTongService = new THeTongServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        THetong tHetong = new THetong();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tHetong, req.getParameterMap());
            tHeTongService.updateContract(tHetong);

            //跳转
            PageResult<THetong> contractPageResult = tHeTongService.findContractsWithPageCount(Integer.parseInt(page));
            ContractPageResultUtils.forwardToListPage(contractPageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
