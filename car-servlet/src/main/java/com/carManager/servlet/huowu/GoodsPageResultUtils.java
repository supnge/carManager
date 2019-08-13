package com.carManager.servlet.huowu;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.servlet.che.CarUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsPageResultUtils {
    //  通过 SijiId 查询name  并回填到pageResult中对应的字段
    public static void forwardToListPage(PageResult goodsPageResult, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<TChe> carList = new ArrayList<>();

        if (goodsPageResult != null) {
            goodsPageResult = CarUtils.addGoodsChepai(goodsPageResult);

            // 单独给一个去重了的车辆列表
            req.setAttribute("cheIdInGoods", CarUtils.removeGoodsDuplicateCar(goodsPageResult, carList));

            req.setAttribute("goodsPageResult", goodsPageResult);
            req.getRequestDispatcher("/admin/products/goodsList.jsp").forward(req, resp);
        }
    }
}
