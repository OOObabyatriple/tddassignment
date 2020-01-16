package com.qa.tddassignment;

import org.easymock.internal.matchers.Any;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    private IWebService webService;


    @Test
    public void userid_correct_length_mock() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid, password)).andReturn(true);
        replay(webService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //assert
        verify(webService);
    }

    @Test
    public void userid_incorrect_length() throws InvalidInputException {
        //arrange
        String userid = "ASA95677";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedObjectType = "Not Allowed";
        String expectedObjectName = "Not Allowed";


        //act
        String resultObjectType = solarSystemInformation.getObjectType();
        String resultObjectName = solarSystemInformation.getObjectName();

        //assert
        assertEquals(expectedObjectName, resultObjectName);
        assertEquals(expectedObjectType, resultObjectType);
    }

    @Test
    public void userid_correct_format() throws InvalidInputException {

        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid, password)).andReturn(true);
        replay(webService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //assert
        verify(webService);
    }

    @Test
    public void userid_incorrect_format() throws InvalidInputException {
        //arrange
        String userid = "ASA95677";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedObjectType = "Not Allowed";
        String expectedObjectName = "Not Allowed";

        //act
        String resultObjectType = solarSystemInformation.getObjectType();
        String resultObjectName = solarSystemInformation.getObjectName();

        //assert
        assertEquals(expectedObjectName, resultObjectName);
        assertEquals(expectedObjectType, resultObjectType);
    }

    @Test
    public void userid_0000_format() throws InvalidInputException {
        //arrange
        String userid = "ASA0000";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedObjectType = "Not Allowed";
        String expectedObjectName = "Not Allowed";

        //act
        String resultObjectType = solarSystemInformation.getObjectType();
        String resultObjectName = solarSystemInformation.getObjectName();

        //assert
        assertEquals(expectedObjectName, resultObjectName);
        assertEquals(expectedObjectType, resultObjectType);
    }

    @Test
    public void password_correct_length() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid, password)).andReturn(true);
        replay(webService);
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //assert
        verify(webService);
    }

    @Test
    public void password_incorrect_length() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Passw1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedObjectType = "Not Allowed";
        String expectedObjectName = "Not Allowed";

        //act
        String resultObjectType = solarSystemInformation.getObjectType();
        String resultObjectName = solarSystemInformation.getObjectName();


        //assert
        assertEquals(expectedObjectName, resultObjectName);
        assertEquals(expectedObjectType, resultObjectType);
    }

    @Test
    public void password_correct_format() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password!1";
        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid, password)).andReturn(true);
        replay(webService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);


        //assert
        verify(webService);

    }

    @Test
    public void password_incorrect_format() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Passw111!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedObjectType = "Not Allowed";
        String expectedObjectName = "Not Allowed";

        //act
        String resultObjectType = solarSystemInformation.getObjectType();
        String resultObjectName = solarSystemInformation.getObjectName();


        //assert
        assertEquals(expectedObjectName, resultObjectName);
        assertEquals(expectedObjectType, resultObjectType);
    }


    @Test
    public void AOC_format_correct() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password!1";
        String AOC = "A99942Apo138M";
        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid,password)).andReturn(true).times(1);

        expect(webService.getStatusInfo(anyString())).andReturn("Complete").times(1);

        replay(webService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        solarSystemInformation.initialiseAOCDetails(AOC);

        //assert
        verify(webService);
    }
    @Test
    public void AOC_format_correct_two() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password!1";
        String AOC = "SSun27TL";
        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid, password)).andReturn(true).times(1);

        expect(webService.getStatusInfo(anyString())).andReturn("Complete").times(1);

        replay(webService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password, webService);
        solarSystemInformation.initialiseAOCDetails(AOC);

        //assert
        verify(webService);
    }
    @Test
    public void AOC_incorrect_format() throws  InvalidInputException{
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        String AOC = "A99942Apo138MM";

        webService = createMock(IWebService.class);
        expect(webService.authenticate(userid, password)).andReturn(true).times(1);

        replay(webService);

        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        //solarSystemInformation.initialiseAOCDetails(AOC);

        //assert
        Assertions.assertThrows(InvalidInputException.class, () -> {
                    String result = solarSystemInformation.initialiseAOCDetails(AOC);
                });

        verify(webService);
    }
    @Test
    public void get_status_info_called_from_web_service() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String AOC ="SSun27TL";
        String expectedoutput="(Star, Sun, sma 27 thousand light years)";

        //act
        String result=solarSystemInformation.initialiseAOCDetails(AOC);

        //assert
        assertEquals(expectedoutput,result);
    }
    }