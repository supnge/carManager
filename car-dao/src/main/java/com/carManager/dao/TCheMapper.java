package com.carManager.dao;

import com.carManager.domain.TChe;
import com.carManager.domain.TCheExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCheMapper {
    long countByExample(TCheExample example);

    int deleteByExample(TCheExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TChe record);

    int insertSelective(TChe record);

    List<TChe> selectByExample(TCheExample example);

    TChe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TChe record, @Param("example") TCheExample example);

    int updateByExample(@Param("record") TChe record, @Param("example") TCheExample example);

    int updateByPrimaryKeySelective(TChe record);

    int updateByPrimaryKey(TChe record);
}