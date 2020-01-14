package com.qa.tddassignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolarSystemInformationTest {

        @Test
        public void userid_correct_length(){
            //arrange
            String userid="AS9567";
            String password="password";
            SolarSystemInformation solarSystemInformation=new SolarSystemInformation(userid,password);
            String expectedoutput="AS9567";

            //act
            String result=solarSystemInformation.getUserid();

            //assert
            assertEquals(expectedoutput,result);
        }
    @Test
    public void userid_incorrect_length(){
        //arrange
        String userid="ASA95677";
        String password="password";
        SolarSystemInformation solarSystemInformation=new SolarSystemInformation(userid,password);
        String expectedoutput="Not allowed";

        //act
        String result=solarSystemInformation.getUserid();

        //assert
        assertEquals(expectedoutput,result);
    }


    }
