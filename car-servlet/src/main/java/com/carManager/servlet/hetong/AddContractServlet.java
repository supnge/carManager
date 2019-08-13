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
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddContractServlet")
public class AddContractServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        THeTongService tHeTongService = new THeTongServiceImpl();

        THetong tHetong = new THetong();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tHetong, req.getParameterMap());

            // 新增时放入两个时间 ：
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

            tHetong.setInsertDate(simpleDateFormat.format(new Date()));
            tHetong.setUpdateDate(simpleDateFormat.format(new Date()));

            tHeTongService.insertContract(tHetong);

            PageResult<THetong> contractPageResult = tHeTongService.findContractsWithPageCount(Integer.parseInt(page));

            ContractPageResultUtils.forwardToListPage(contractPageResult, req, resp);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
