package com.qgStudio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qgStudio.entity.Strip;


/**
 * 服务接口
 * @author yinjunbiao
 * @version 1.0
 */
public interface StripService extends IService<Strip> {
    void insert(Strip strip);

    void createTable();
}
