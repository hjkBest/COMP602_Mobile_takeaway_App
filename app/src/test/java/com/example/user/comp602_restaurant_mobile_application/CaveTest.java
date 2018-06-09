package com.example.user.comp602_restaurant_mobile_application;

import org.junit.Assert;
import org.junit.Test;

public class CaveTest {
    private Cave unittest;

    @Test
    public void setUp() throws Exception {
        unittest = new Cave();
    }
    public void testsum(){
        Assert.assertEquals(30, unittest.CalculatePrice(15, 2), 0);
    }
}