package com.carManager.dao;

import com.carManager.domain.THetong;
import com.carManager.domain.THetongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THetongMapper {
    long countByExample(THetongExample example);

    int deleteByExample(THetongExample example);

    int insert(THetong record);

    int insertSelective(THetong record);

    List<THetong> selectByExample(THetongExample example);

    int updateByExampleSelective(@Param("record") THetong record, @Param("example") THetongExample example);

    int updateByExample(@Param("record") THetong record, @Param("example") THetongExample example);
}