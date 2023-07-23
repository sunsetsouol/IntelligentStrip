package com.qgStudio;

import com.qgStudio.mapper.StripMapper;
import com.qgStudio.service.StripService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntelligentStripApplicationTests {

    @Autowired
    private StripService service;

    @Autowired
    private StripMapper stripMapper;
    @Test
    void contextLoads() {
        //        service.createTable();
    }


}
