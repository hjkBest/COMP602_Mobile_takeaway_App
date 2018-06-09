package com.example.user.comp602_restaurant_mobile_application;

import org.junit.Assert;
import org.junit.Test;

public class KimchiTest {
    private Kimchi unittest;
    @Test
    public void setUp() throws Exception {
        unittest = new Kimchi();
    }
    public void testsum(){
        Assert.assertEquals(30, unittest.CalculatePrice(15, 2), 0);
    }
}