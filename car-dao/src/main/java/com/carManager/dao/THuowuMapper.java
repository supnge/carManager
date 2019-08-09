package com.carManager.dao;

import com.carManager.domain.THuowu;
import com.carManager.domain.THuowuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THuowuMapper {
    long countByExample(THuowuExample example);

    int deleteByExample(THuowuExample example);

    int insert(THuowu record);

    int insertSelective(THuowu record);

    List<THuowu> selectByExample(THuowuExample example);

    int updateByExampleSelective(@Param("record") THuowu record, @Param("example") THuowuExample example);

    int updateByExample(@Param("record") THuowu record, @Param("example") THuowuExample example);
}