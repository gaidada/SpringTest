package com.gai.factory;

import com.gai.bean.AirPlane;

public class AirPlaneInstanceFactory {
    public  AirPlane getAirPlane(String jzName) {
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setYc("198m");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(350);
        return airPlane;
    }
}
