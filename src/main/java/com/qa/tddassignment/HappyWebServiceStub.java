package com.qa.tddassignment;

public class HappyWebServiceStub implements IWebService{

    private boolean authenticated;
    @Override
    public boolean authenticate(String userid,String password) {

        return authenticated =true;
    }
    @Override
    public String getStatusInfo(String astronomicalObjectClassificationCode){
        switch(astronomicalObjectClassificationCode){
            case "SSun27TL":
                return "(Star, Sun, sma 27 thousand light years)";
            case "PMer58M":
                return "(Planet, Mercury, sma 58 million km)";
            case "A99942Apo138M":
                return"(Asteroid, 99942 Apophis, sma 138 million km)";

        }
        return null;
    }
}
