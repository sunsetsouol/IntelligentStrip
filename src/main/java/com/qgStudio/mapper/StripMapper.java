package com.qgStudio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qgStudio.entity.Strip;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StripMapper extends BaseMapper<Strip> {

    void createTable(@Param("tableName") String tableName);

    @Insert("insert into ${tableName} values (null,'1',#{strip.time},#{strip.Temp},#{strip.MQ},#{strip.Socket1},#{strip.Socket2},#{strip.Socket3},#{strip.Vrms1}," +
            "#{strip.Irms1},#{strip.PActive1},#{strip.W_KWH1},#{strip.Vrms2},#{strip.Irms2},#{strip.PActive2},#{strip.W_KWH2},#{strip.Vrms3},#{strip.Irms3},#{strip.PActive3},#{strip.W_KWH3})")
    void add(@Param("tableName") String tableName,@Param("strip") Strip strip);


}