package com.qa.tddassignment;

import java.util.regex.*;
import java.math.BigDecimal;

public class SolarSystemInformation {

    private String userid;
    private String password;
    private String astronomicalObjectClassificationCode;
    private String objectType;
    private String objectName;
    private boolean exists;
    private int orbitalPeriod;
    private BigDecimal radius;
    private BigDecimal semiMajorAxis;
    private BigDecimal mass;


    public SolarSystemInformation(String userid, String password) {
        if (userid.length()==6){
            if(userid.matches("^[A-Z]{2}[0-9]{4}(?!0000)")){
                this.userid=userid;
            }
            else this.userid="Pattern no match";
        }
        else{
            this.userid="Not allowed";
            setAstronomicalObjectClassificationCode("0");
            setObjectType("0");
            setObjectName("0");
            setExists(false);
            setOrbitalPeriod(0);
            setRadius(BigDecimal.ZERO);
            setSemiMajorAxis(BigDecimal.ZERO);
            setMass(BigDecimal.ZERO);

        }
        //if(password.length()>=10){
            if(password.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$")){
                this.password=password;
            }
            else{
                this.password="Not allowed";
            }
        }
        //else{
          //  this.password="Not allowed";
        //}
    //}

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAstronomicalObjectClassificationCode() {
        return astronomicalObjectClassificationCode;
    }

    public void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) {
        this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public int getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(int orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public BigDecimal getSemiMajorAxis() {
        return semiMajorAxis;
    }

    public void setSemiMajorAxis(BigDecimal semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public BigDecimal getMass() {
        return mass;
    }

    public void setMass(BigDecimal mass) {
        this.mass = mass;
    }

}
