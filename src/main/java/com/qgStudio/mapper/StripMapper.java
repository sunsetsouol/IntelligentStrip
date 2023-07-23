package com.qgStudio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgStudio.entity.Strip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StripMapper extends BaseMapper<Strip> {

    void createTable(@Param("tableName") String tableName);


}
