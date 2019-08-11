package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.TChuche;
import com.carManager.service.TCheService;
import com.carManager.service.TChuCheService;
import com.carManager.service.impl.TCheServiceImpl;
import com.carManager.service.impl.TChuCheServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet("/RecordListServlet")
public class RecordListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 查询
        TChuCheService tChuCheService = new TChuCheServiceImpl();
        TCheService tCheService = new TCheServiceImpl();

        // 获取页码
        String page = req.getParameter("page");
        if (page == null || "".equals(page)) {
            page = "1";
        }

        //分页查询数据：
        try {
            PageResult<TChuche> recordPageResult = tChuCheService.findRecordsWithPageCount(Integer.parseInt(page));
            List<TChuche> carList ;
            if (recordPageResult != null) {
                //TChuche里添加的字段，通过CheId进行查询，存入对应的车牌号
                for(Iterator iterator = recordPageResult.getList().iterator(); iterator.hasNext();){
                    TChuche tChuche = (TChuche)iterator.next();
                    tChuche.setChepai(tCheService.findCarById(tChuche.getCheId()).getChepai());
                    // 发送给查询列表的，用来去重复
                }

                // 如果list里cheId数据对应的车号一样，则删除掉, 目的是完成下拉查询去重复
                // 感觉后台不好实现，在前端实现吧

                req.setAttribute("recordPageResult", recordPageResult);
                req.getRequestDispatcher("/admin/products/recordList.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
