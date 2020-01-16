package com.qa.tddassignment;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class SolarSystemInformation {
    private final HappyWebServiceStub webService = new HappyWebServiceStub();
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


    public SolarSystemInformation(String userid, String password, IWebService webService) throws InvalidInputException {
        if (userid.length() != 6 && !userid.matches("^[A-Z]{2}[0-9]{4}(?!0000)")) {

            AuthentcationFailedSetFieldsToDefaults();
            return;
        }
        this.userid = userid;

        if (!password.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$")) {
            AuthentcationFailedSetFieldsToDefaults();
            return;
        }
        this.password = password;
        if(!webService.authenticate(this.userid, this.password)){
            AuthentcationFailedSetFieldsToDefaults();
            return;
        }
    }

    private void AuthentcationFailedSetFieldsToDefaults() {
        setAstronomicalObjectClassificationCode("0");
        setObjectType("Not Allowed");
        setObjectName("Not Allowed");
        setExists(false);
        setOrbitalPeriod(0);
        setRadius(BigDecimal.ZERO);
        setSemiMajorAxis(BigDecimal.ZERO);
        setMass(BigDecimal.ZERO);
        return;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getAstronomicalObjectClassificationCode() {

        return astronomicalObjectClassificationCode;
    }

    private void setAstronomicalObjectClassificationCode(String astronomicalObjectClassificationCode) {
        this.astronomicalObjectClassificationCode = astronomicalObjectClassificationCode;
    }

    public String getObjectType() throws InvalidInputException {
       // List<String> types=Arrays.asList("Star","Planet","Moon","Dwarf Planet","Asteroid","Comet","Not allowed");
       // if(types.contains(objectType)){
      //      return this.objectType;
      //  }
      //  else{
       //     throw new InvalidInputException("Object type invalid");
        return objectType;
        }

    private void setObjectType(String objectType){
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
            String output=webService.getStatusInfo(astronomicalObjectClassificationCode);
            return output;

        }
        else throw new InvalidInputException("AOC: Invalid Format");
    }
}
