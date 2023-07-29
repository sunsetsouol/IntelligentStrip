package com.qgStudio.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qgStudio.mapper.StripMapper;
import com.qgStudio.entity.Strip;
import com.qgStudio.service.StripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * 服务实现类
 * @author yinjunbiao
 * @version 1.0
 */
@Service
public class StripServiceImpl extends ServiceImpl<StripMapper, Strip> implements StripService{

    private static String TABLENAME = "strip_";

    @Autowired
    private StripMapper stripMapper;


    @Override
    public void insert(Strip strip) throws IOException {
        String format = Strip.format1.format(new Date());
        strip.setTime(Strip.format2.format(new Date()));
        stripMapper.createTable(TABLENAME + format);
        stripMapper.add(TABLENAME + format,strip);
    }
}
