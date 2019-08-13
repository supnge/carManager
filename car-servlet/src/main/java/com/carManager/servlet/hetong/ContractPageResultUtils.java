package com.carManager.servlet.hetong;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.domain.THuowu;
import com.carManager.servlet.che.CarUtils;
import com.carManager.servlet.huowu.GoodsUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractPageResultUtils {
    //  通过 SijiId 查询name  并回填到pageResult中对应的字段
    public static void forwardToListPage(PageResult contractPageResult, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        List<TChe> carList = new ArrayList<>();
        List<THuowu> huowuList = new ArrayList<>();

        if (contractPageResult != null) {
            // 添加车牌
            contractPageResult = CarUtils.addContractChepai(contractPageResult);
            // 添加货物名
            contractPageResult = GoodsUtils.addContractGoodName(contractPageResult);

            // 单独给一个去重了的车辆列表
            req.setAttribute("cheIdInContract", CarUtils.removeContractDuplicateCar(contractPageResult, carList));
            // 去重的货物列表
            req.setAttribute("goodsIdInContract", GoodsUtils.removeContractDuplicateGoods(contractPageResult, huowuList));

            req.setAttribute("contractPageResult", contractPageResult);
            req.getRequestDispatcher("/admin/products/contractList.jsp").forward(req, resp);
        }
    }
}
