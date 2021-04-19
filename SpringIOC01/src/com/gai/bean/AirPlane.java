package com.gai.bean;

public class AirPlane {
    private String fdj;//发动机
    private String yc;//机翼长度
    private Integer personNum;//载客量
    private String jzName;//机长名字

    public AirPlane() {
    }

    public AirPlane(String fdj, String yc, Integer personNum, String jzName) {
        this.fdj = fdj;
        this.yc = yc;
        this.personNum = personNum;
        this.jzName = jzName;
    }

    public String getFdj() {
        return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String getJzName() {
        return jzName;
    }

    public void setJzName(String jzName) {
        this.jzName = jzName;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "fdj='" + fdj + '\'' +
                ", yc='" + yc + '\'' +
                ", personNum=" + personNum +
                ", jzName='" + jzName + '\'' +
                '}';
    }
}
