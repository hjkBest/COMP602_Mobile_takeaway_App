package com.example.user.comp602_restaurant_mobile_application;
import org.junit.Assert;
import org.junit.Test;

public class paparichmenuTest {
    private paparichmenu pap;
    @Test
    public void setUp() throws Exception {
        pap = new paparichmenu();
    }
    public void testsum(){
        Assert.assertEquals(30, pap.CalculatePrice(15, 2), 0);
    }
}