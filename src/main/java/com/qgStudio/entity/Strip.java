package com.qgStudio.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * 排插对象
 * @author yinjunbiao
 * @version 1.0
 */

public class Strip {

    public static SimpleDateFormat format1;

    public static SimpleDateFormat format2;

    static {
        format1 = new SimpleDateFormat("yyyyMMdd");
        format2 = new SimpleDateFormat("HH-mm-ss");
    }
    private Long id;

    private Integer warn;

    private String time;

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

    public Strip() {
    }

    @Override
    public String toString() {
        return "Strip{" +
                "id=" + id +
                ", warn=" + warn +
                ", time='" + time + '\'' +
                ", Temp=" + Temp +
                ", MQ=" + MQ +
                ", Socket1=" + Socket1 +
                ", Socket2=" + Socket2 +
                ", Socket3=" + Socket3 +
                ", Vrms1=" + Vrms1 +
                ", Irms1=" + Irms1 +
                ", PActive1=" + PActive1 +
                ", W_KWH1=" + W_KWH1 +
                ", Vrms2=" + Vrms2 +
                ", Irms2=" + Irms2 +
                ", PActive2=" + PActive2 +
                ", W_KWH2=" + W_KWH2 +
                ", Vrms3=" + Vrms3 +
                ", Irms3=" + Irms3 +
                ", PActive3=" + PActive3 +
                ", W_KWH3=" + W_KWH3 +
                '}';
    }

    public Strip(Long id, Integer warn, String time, BigDecimal temp, BigDecimal MQ, Integer socket1, Integer socket2, Integer socket3, BigDecimal vrms1, BigDecimal irms1, BigDecimal PActive1, BigDecimal w_KWH1, BigDecimal vrms2, BigDecimal irms2, BigDecimal PActive2, BigDecimal w_KWH2, BigDecimal vrms3, BigDecimal irms3, BigDecimal PActive3, BigDecimal w_KWH3) {
        this.id = id;
        this.warn = warn;
        this.time = time;
        Temp = temp;
        this.MQ = MQ;
        Socket1 = socket1;
        Socket2 = socket2;
        Socket3 = socket3;
        Vrms1 = vrms1;
        Irms1 = irms1;
        this.PActive1 = PActive1;
        W_KWH1 = w_KWH1;
        Vrms2 = vrms2;
        Irms2 = irms2;
        this.PActive2 = PActive2;
        W_KWH2 = w_KWH2;
        Vrms3 = vrms3;
        Irms3 = irms3;
        this.PActive3 = PActive3;
        W_KWH3 = w_KWH3;
    }

    public static SimpleDateFormat getFormat1() {
        return format1;
    }

    public static void setFormat1(SimpleDateFormat format1) {
        Strip.format1 = format1;
    }

    public static SimpleDateFormat getFormat2() {
        return format2;
    }

    public static void setFormat2(SimpleDateFormat format2) {
        Strip.format2 = format2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWarn() {
        return warn;
    }

    public void setWarn(Integer warn) {
        this.warn = warn;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getTemp() {
        return Temp;
    }

    public void setTemp(BigDecimal temp) {
        Temp = temp;
    }

    public BigDecimal getMQ() {
        return MQ;
    }

    public void setMQ(BigDecimal MQ) {
        this.MQ = MQ;
    }

    public Integer getSocket1() {
        return Socket1;
    }

    public void setSocket1(Integer socket1) {
        Socket1 = socket1;
    }

    public Integer getSocket2() {
        return Socket2;
    }

    public void setSocket2(Integer socket2) {
        Socket2 = socket2;
    }

    public Integer getSocket3() {
        return Socket3;
    }

    public void setSocket3(Integer socket3) {
        Socket3 = socket3;
    }

    public BigDecimal getVrms1() {
        return Vrms1;
    }

    public void setVrms1(BigDecimal vrms1) {
        Vrms1 = vrms1;
    }

    public BigDecimal getIrms1() {
        return Irms1;
    }

    public void setIrms1(BigDecimal irms1) {
        Irms1 = irms1;
    }

    public BigDecimal getPActive1() {
        return PActive1;
    }

    public void setPActive1(BigDecimal PActive1) {
        this.PActive1 = PActive1;
    }

    public BigDecimal getW_KWH1() {
        return W_KWH1;
    }

    public void setW_KWH1(BigDecimal w_KWH1) {
        W_KWH1 = w_KWH1;
    }

    public BigDecimal getVrms2() {
        return Vrms2;
    }

    public void setVrms2(BigDecimal vrms2) {
        Vrms2 = vrms2;
    }

    public BigDecimal getIrms2() {
        return Irms2;
    }

    public void setIrms2(BigDecimal irms2) {
        Irms2 = irms2;
    }

    public BigDecimal getPActive2() {
        return PActive2;
    }

    public void setPActive2(BigDecimal PActive2) {
        this.PActive2 = PActive2;
    }

    public BigDecimal getW_KWH2() {
        return W_KWH2;
    }

    public void setW_KWH2(BigDecimal w_KWH2) {
        W_KWH2 = w_KWH2;
    }

    public BigDecimal getVrms3() {
        return Vrms3;
    }

    public void setVrms3(BigDecimal vrms3) {
        Vrms3 = vrms3;
    }

    public BigDecimal getIrms3() {
        return Irms3;
    }

    public void setIrms3(BigDecimal irms3) {
        Irms3 = irms3;
    }

    public BigDecimal getPActive3() {
        return PActive3;
    }

    public void setPActive3(BigDecimal PActive3) {
        this.PActive3 = PActive3;
    }

    public BigDecimal getW_KWH3() {
        return W_KWH3;
    }

    public void setW_KWH3(BigDecimal w_KWH3) {
        W_KWH3 = w_KWH3;
    }
}
