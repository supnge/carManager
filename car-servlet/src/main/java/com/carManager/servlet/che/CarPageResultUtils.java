package com.carManager.servlet.che;

import com.carManager.domain.PageResult;
import com.carManager.domain.TChe;
import com.carManager.service.TSijiService;
import com.carManager.service.impl.TSijiServiceImpl;

import java.sql.SQLException;
import java.util.Iterator;

public class CarPageResultUtils {
    //  通过 SijiId 查询name  并回填到pageResult中对应的字段
    public static PageResult putDriverName(PageResult carPageResult) throws SQLException {
        TSijiService tSijiService = new TSijiServiceImpl();
            for(Iterator iterator = carPageResult.getList().iterator(); iterator.hasNext();){
                TChe tChe =  (TChe)iterator.next();
                tChe.setDriverName(tSijiService.findSijiById(tChe.getSijiId()).getName());
        }
        return  carPageResult;
    }

}
