package com.qa.tddassignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

    @Test
    public void userid_correct_length() {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "AS9567";

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertEquals(expectedoutput, result);
    }

    @Test
    public void userid_incorrect_length() {
        //arrange
        String userid = "ASA95677";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "Not allowed";

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertEquals(expectedoutput, result);
    }

    @Test
    public void userid_correct_format() {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertTrue(result.matches("^[A-Z]{2}[0-9]{4}"));
    }

    @Test
    public void userid_incorrect_format() {
        //arrange
        String userid = "ASA95677";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertFalse(result.matches("^[A-Z]{2}[0-9]{4}"));
    }

    @Test
    public void userid_0000_format() {
        //arrange
        String userid = "ASA0000";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);

        //act
        String result = solarSystemInformation.getUserid();

        //assert
        assertFalse(result.matches("^[A-Z]{2}[0-9]{4}(?!0000)"));
    }

    @Test
    public void password_correct_length() {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "Password1!";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
    }

    @Test
    public void password_incorrect_length() {
        //arrange
        String userid = "AS9567";
        String password = "Passw1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "Not allowed";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
    }

    @Test
    public void password_correct_format() {
        //arrange
        String userid = "AS9567";
        String password = "Password!1";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "Password!1";

        //act
        String result = solarSystemInformation.getPassword();

        //assert
        assertEquals(expectedoutput, result);
        assertTrue(result.matches("^(?=.{10,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$"));
    }

    @Test
    public void password_incorrect_format() {
        //arrange
        String userid = "AS9567";
        String password = "Password111";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "Not allowed";

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
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "PMer58M";

        //act
        String result = solarSystemInformation.initialiseAOCDetails("PMer58M");

        //assert
        assertEquals(expectedoutput, result);
        assertTrue(result.matches("[A-Z][0-9]{0,8}[A-Z][a-z]{2}[0-9]{1,3}(T|M|B|L|TL)"));
    }
    @Test
    public void AOC_format_correct_two() throws InvalidInputException {
        //arrange
        String userid = "AS9567";
        String password = "Password1!";
        SolarSystemInformation solarSystemInformation = new SolarSystemInformation(userid, password);
        String expectedoutput = "A99942Apo138M";

        //act
        String result = solarSystemInformation.initialiseAOCDetails("A99942Apo138M");

        //assert
        assertEquals(expectedoutput, result);
        assertTrue(result.matches("[A-Z][0-9]{0,8}[A-Z][a-z]{2}[0-9]{1,3}(T|M|B|L|TL)"));
    }
    }