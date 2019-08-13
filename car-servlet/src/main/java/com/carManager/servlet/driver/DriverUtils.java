package com.carManager.servlet.driver;

import com.carManager.domain.TSiji;

import java.util.*;

public class DriverUtils {
    public static List<TSiji> removeDuplicateUser(List<TSiji> driverList){
        // 根据车id去重
        Set<TSiji> driverSet = new TreeSet<>(Comparator.comparing(TSiji::getId));

        driverSet.addAll(driverList);
        List<TSiji> driverIdInRecord= new ArrayList<>(driverSet);

        return driverIdInRecord;
    }
}
