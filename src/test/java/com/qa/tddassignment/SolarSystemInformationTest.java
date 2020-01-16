package com.qa.tddassignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    private IWebService webService;


    @Test
    public void userid_correct_length() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertEquals(userid, result);
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
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertTrue(result.matches("^[A-Z]{2}[0-9]{4}"));
    }

    @Test
    public void userid_incorrect_format() throws InvalidInputException {
        //arrange
        String userid = "ASA95677";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertFalse(result.matches("^[A-Z]{2}[0-9]{4}"));
    }

    @Test
    public void userid_0000_format() throws InvalidInputException {
        //arrange
        String userid = "ASA0000";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertFalse(result.matches("^[A-Z]{2}[0-9]{4}(?!0000)"));
    }

    @Test
    public void password_correct_length() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedoutput = "Password1!";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
    }

    @Test
    public void password_incorrect_length() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Passw1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedoutput = "Password Invalid";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
    }

    @Test
    public void password_correct_format() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password!1";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedoutput = "Password!1";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
        assertTrue(result.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$"));
    }

    @Test
    public void password_incorrect_format() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password111";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String expectedoutput = "Password Invalid";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
        assertFalse(result.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$"));
    }
    @Test
    public void AOC_format_correct() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        webService = new HappyWebServiceStub();
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String AOC = "PMer58M";

        //act
        solarSystemInformation.initialiseAOCDetails(AOC);
        String result=solarSystemInformation.getAstronomicalObjectClassificationCode();

        //assert
        assertEquals(AOC, result);

    }
    @Test
    public void AOC_format_correct_two() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String AOC = "A99942Apo138M";

        //act
        solarSystemInformation.initialiseAOCDetails(AOC);
        String result=solarSystemInformation.getAstronomicalObjectClassificationCode();

        //assert
        assertEquals(AOC, result);
        assertTrue(result.matches("[A-Z][0-9]{0,8}[A-Z][a-z]{2}[0-9]{1,3}(T|M|B|L|TL)"));
    }
    @Test
    public void AOC_incorrect_format() throws  InvalidInputException{
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password,webService);
        String AOC = "A99942Apo138MM";


        //assert
        Assertions.assertThrows(InvalidInputException.class, () -> {
                    String result = solarSystemInformation.initialiseAOCDetails(AOC);
                });
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