package com.qa.tddassignment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            if(password.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$")){
                this.password=password;
            }
            else{
                this.password="Not allowed";
                setAstronomicalObjectClassificationCode("0");
                setObjectType("0");
                setObjectName("0");
                setExists(false);
                setOrbitalPeriod(0);
                setRadius(BigDecimal.ZERO);
                setSemiMajorAxis(BigDecimal.ZERO);
                setMass(BigDecimal.ZERO);
            }
        }

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

    private void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) {
        this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
    }

    public String getObjectType() {
        return this.objectType;
    }

    private void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getObjectName() {
        return objectName;
    }

    private void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public boolean isExists() {
        return exists;
    }

    private void setExists(boolean exists) {
        this.exists = exists;
    }

    public int getOrbitalPeriod() {
        return orbitalPeriod;
    }

    private void setOrbitalPeriod(int orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    private void setRadius(BigDecimal radius) {
        this.radius = radius;
    }

    public BigDecimal getSemiMajorAxis() {
        return semiMajorAxis;
    }

    private void setSemiMajorAxis(BigDecimal semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    public BigDecimal getMass() {
        return mass;
    }

    private void setMass(BigDecimal mass) {
        this.mass = mass;
    }


    //[A-Z]{1}[0-9]{0,8}[A-Z][a-z]{2}[0-9]{1,3}(T|M|B|L|TL)
    public String initialiseAOCDetails(String astronomicalObjectClassificationCode) throws InvalidInputException {
        if(astronomicalObjectClassificationCode.matches("[A-Z][0-9]{0,8}[A-Z][a-z]{2}[0-9]{1,3}(T|M|B|L|TL)")){
            return astronomicalObjectClassificationCode;

        }
        else throw new InvalidInputException("AOC: Invalid Format");
    }
}
