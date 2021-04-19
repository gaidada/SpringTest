package com.gai.factory;

import com.gai.bean.AirPlane;

public class AirPlaneStaticFactory {

    public static AirPlane getAirPlane(String jzName) {

        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("兰博");
        airPlane.setYc("150m");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        return airPlane;
    }
}
