package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.TChuche;
import com.carManager.service.TCheService;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TChuCheServiceImpl;
import com.carManager.servlet.che.CarUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {
    TChuCheService tChuCheService = new TChuCheServiceImpl();
    TCheService tCheService = new TCheServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");


        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            TChuche tChuche = new TChuche();

            BeanUtils.populate(tChuche, req.getParameterMap());
            tChuCheService.updateRecord(tChuche);

            PageResult<TChuche> recordPageResult = tChuCheService.findRecordsWithPageCount(Integer.parseInt(page));
            RecordPageResultUtils.forwardToListPage(recordPageResult, req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
