package com.example.demo.utils;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TimeUtilsTest {

    @Test
    public void transLocalTime() {
    }

    @Test
    public void transLocalDate() {
    }

    @Test
    public void transLocalDateTime() {
    }

    @Test
    public void converseTrans() {
    }

    @Test
    public void testConverseTrans() {
        LocalDate time=LocalDate.of(2020,1,1);
        System.out.println(TimeUtils.converseTrans(time));
    }
}