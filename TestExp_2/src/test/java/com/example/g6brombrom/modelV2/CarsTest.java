package com.example.g6brombrom.modelV2;

import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;


import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("Test that setMerke properly sets value")
    void test_setMerke_setsProperly()throws NoSuchFieldException, IllegalAccessException {
    final Cars car = new Cars();
    final Field field = car.getClass().getDeclaredField("merke");
    field.setAccessible(true);
    //when
        final StringProperty qq = car.merkeProperty();
        assertEquals("hi ha",qq,"Field wasnt set Properly");

    }

    @Test
    @DisplayName("Test that setMerke properly retrives value")
    void test_getMerke_getsValue() throws NoSuchFieldException, IllegalAccessException {
        final Cars car = new Cars();
        final Field field = car.getClass().getDeclaredField("merke");
        field.setAccessible(true);
        //when
        final StringProperty qq = car.merkeProperty();
        assertEquals("fi fom",qq,"Field wasnt retrived Properly");
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