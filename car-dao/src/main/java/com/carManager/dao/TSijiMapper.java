package com.carManager.dao;

import com.carManager.domain.TSiji;
import com.carManager.domain.TSijiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSijiMapper {
    long countByExample(TSijiExample example);

    int deleteByExample(TSijiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSiji record);

    int insertSelective(TSiji record);

    List<TSiji> selectByExample(TSijiExample example);

    TSiji selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSiji record, @Param("example") TSijiExample example);

    int updateByExample(@Param("record") TSiji record, @Param("example") TSijiExample example);

    int updateByPrimaryKeySelective(TSiji record);

    int updateByPrimaryKey(TSiji record);
}