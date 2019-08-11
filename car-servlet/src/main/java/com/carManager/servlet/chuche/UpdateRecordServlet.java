package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChuche;
import com.carManager.domain.TSiji;
import com.carManager.service.TCheService;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TChuCheServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;

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

            if(recordPageResult !=null) {

                for (Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext(); ) {
                    tChuche = (TChuche) iterator.next();
                    tChuche.setChepai(tCheService.findCarById(tChuche.getCheId()).getChepai());
                }

                //跳转
                req.setAttribute("recordPageResult", recordPageResult);
                req.getRequestDispatcher("/admin/products/recordList.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
