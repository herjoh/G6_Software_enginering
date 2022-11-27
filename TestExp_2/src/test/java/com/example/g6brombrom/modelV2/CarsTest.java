package com.example.g6brombrom.modelV2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void test_setMerke_setsProperly()throws NoSuchFieldException, IllegalAccessException {


        //Given
        final Cars car = new Cars();
        //When

        //Then
        final Field field = car.getClass().getDeclaredField("merke");
        field.setAccessible(true);
        assertEquals("hi ha", field.get(car),"Fields dont match");
    }

    @Test
    void test_getMerke_getsValue() throws NoSuchFieldException, IllegalAccessException {
        //Given
        final Cars car = new Cars();
        final Field field = car.getClass().getDeclaredField("merke");
        field.setAccessible(true);
        field.set(car,"magic_values");
        //when
        final String result = car.getMerke();
        final StringProperty qq = car.merkeProperty();
        //Then
        assertEquals("magic_values",qq, "Field wasn't retrieved properly");
    }


    @Test
    void getModell() {
    }



    @Test
    void setModell() {
    }

    @Test
    void getEier() {
    }



    @Test
    void setEier() {
    }

    @Test
    void getÅrsmodel() {
    }



    @Test
    void setÅrsmodell() {
    }

    @Test
    void getFarge() {
    }



    @Test
    void setFarge() {
    }

    @Test
    void getOmråde() {
    }



    @Test
    void setOmråde() {
    }

    @Test
    void isLedighet() {
    }



    @Test
    void setTilgjenglig() {
    }

    @Test
    void getDato() {
    }



    @Test
    void setledigdato() {
    }

    @Test
    void getRegestreringsNummer() {
    }



    @Test
    void setRegestreringsNummer() {
    }

    @Test
    void getInsert() {
    }



    @Test
    void setInsert() {
    }
}