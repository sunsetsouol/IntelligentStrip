package com.qgStudio.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * 排插对象
 * @author yinjunbiao
 * @version 1.0
 */
public class Strip {

    public static SimpleDateFormat format;
    static {
        format = new SimpleDateFormat("yyyy/MM/dd");
    }
    private Long id;

    private String equipment;
    private BigDecimal Temp;

    private BigDecimal MQ;

    private Integer Socket1;


    private Integer Socket2;

    private Integer Socket3;


    private BigDecimal Vrms1;
    private BigDecimal Irms1;

    private BigDecimal PActive1;
    private BigDecimal W_KWH1;

    private BigDecimal Vrms2;

    private BigDecimal Irms2;

    private BigDecimal PActive2;

    private BigDecimal W_KWH2;

    private BigDecimal Vrms3;

    private BigDecimal Irms3;

    private BigDecimal PActive3;

    private BigDecimal W_KWH3;
}
