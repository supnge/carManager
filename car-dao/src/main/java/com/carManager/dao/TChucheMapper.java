package com.carManager.dao;

import com.carManager.domain.TChuche;
import com.carManager.domain.TChucheExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChucheMapper {
    long countByExample(TChucheExample example);

    int deleteByExample(TChucheExample example);

    int deleteByPrimaryKey(Integer cheId);

    int insert(TChuche record);

    int insertSelective(TChuche record);

    List<TChuche> selectByExample(TChucheExample example);

    TChuche selectByPrimaryKey(Integer cheId);

    int updateByExampleSelective(@Param("record") TChuche record, @Param("example") TChucheExample example);

    int updateByExample(@Param("record") TChuche record, @Param("example") TChucheExample example);

    int updateByPrimaryKeySelective(TChuche record);

    int updateByPrimaryKey(TChuche record);
}