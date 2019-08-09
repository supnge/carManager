package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChuche;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TChuCheServiceImpl;
import com.carManager.utils.DateUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddRecordServlet")
public class AddRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        TChuCheService tChuCheService = new TChuCheServiceImpl();

        TChuche tChuche = new TChuche();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        try {
            BeanUtils.populate(tChuche, req.getParameterMap());

            tChuche.setInsertDate(DateUtils.dataFormat());
            tChuche.setUpdateDate(DateUtils.dataFormat());

            tChuCheService.insertRecord(tChuche);

            PageResult<TChuche> recordPageResult = tChuCheService.findRecordsWithPageCount(Integer.parseInt(page));

            if (recordPageResult != null) {

                req.setAttribute("recordPageResult", recordPageResult);
                req.getRequestDispatcher("/admin/products/recordList.jsp").forward(req, resp);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
