package com.yinjunbiao.service.Impl;

import com.yinjunbiao.dao.StripMapper;
import com.yinjunbiao.entity.Strip;
import com.yinjunbiao.service.StripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StripServiceImpl implements StripService {

    @Autowired
    private StripMapper stripMapper;

    @Override
    public void save(Strip strip) {
        stripMapper.insert(strip);
    }
}
