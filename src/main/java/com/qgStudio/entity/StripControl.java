package com.qgStudio.entity;

public class StripControl {

    private Integer Socket1;

    private Integer Socket2;

    private Integer Socket3;

    private Integer time;

    @Override
    public String toString() {
        return "StripControl{" +
                "Socket1=" + Socket1 +
                ", Socket2=" + Socket2 +
                ", Socket3=" + Socket3 +
                ", time=" + time +
                '}';
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public StripControl() {
    }

    public StripControl(Integer socket1, Integer socket2, Integer socket3, Integer time) {
        Socket1 = socket1;
        Socket2 = socket2;
        Socket3 = socket3;
        this.time = time;
    }
}
