package com.carManager.servlet.chuche;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TSijiServiceImpl;
import com.carManager.servlet.che.CarUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecordPageResultUtils {
    //  通过 SijiId 查询name  并回填到pageResult中对应的字段
    public static void forwardToListPage(PageResult recordPageResult, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<TChe> carList = new ArrayList<>();

        if(recordPageResult!=null) {
            recordPageResult = CarUtils.addRecordsChepai(recordPageResult);

            // 单独给一个去重了的车辆列表
            req.setAttribute("cheIdInRecord", CarUtils.removeRecordsDuplicateCar(recordPageResult, carList));

            req.setAttribute("recordPageResult", recordPageResult);
            req.getRequestDispatcher("/admin/products/recordList.jsp").forward(req, resp);
        }
    }
}
