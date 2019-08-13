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

    // 遍历取出对应的姓名、手机、油卡
    public static List<String> getAttr(List<TSiji> sijiList, String attrName){
        List<String> attrList = new ArrayList<>();
        for(Iterator iterator = sijiList.iterator(); iterator.hasNext();){
            TSiji tSiji = (TSiji) iterator.next();
            if("name".equals(attrName)){
                attrList.add(tSiji.getName());
            }
            if("tel".equals(attrName)){
                attrList.add(tSiji.getTel());
            }
            if("oilCard".equals(attrName)){
                attrList.add(tSiji.getOilCard());
            }
        }
        return attrList;
    }

    // 去重
    public static List<String>  removeDuplicateValues(List<String> attrList){
        Set<String> set = new LinkedHashSet<>();
        set.addAll(attrList);
        attrList.clear();
        attrList.addAll(set);
        return attrList;
    }
}
