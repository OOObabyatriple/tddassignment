package com.qa.tddassignment;

public interface IWebService {

    public boolean authenticate(String userid,String password);
    public String getStatusInfo(String astronomicalObjectClassificationCode);
}
