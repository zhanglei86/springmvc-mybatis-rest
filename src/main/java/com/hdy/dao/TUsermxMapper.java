package com.hdy.dao;

import com.hdy.model.TUsermx;
import com.hdy.model.TUsermxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUsermxMapper {
    int countByExample(TUsermxExample example);

    int deleteByExample(TUsermxExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TUsermx record);

    int insertSelective(TUsermx record);

    List<TUsermx> selectByExampleWithBLOBs(TUsermxExample example);

    List<TUsermx> selectByExample(TUsermxExample example);

    TUsermx selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TUsermx record, @Param("example") TUsermxExample example);

    int updateByExampleWithBLOBs(@Param("record") TUsermx record, @Param("example") TUsermxExample example);

    int updateByExample(@Param("record") TUsermx record, @Param("example") TUsermxExample example);

    int updateByPrimaryKeySelective(TUsermx record);

    int updateByPrimaryKeyWithBLOBs(TUsermx record);

    int updateByPrimaryKey(TUsermx record);
    
	List<TUsermx> getAllUser();

}