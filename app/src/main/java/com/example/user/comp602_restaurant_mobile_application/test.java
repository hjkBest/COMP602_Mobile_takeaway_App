package com.example.user.comp602_restaurant_mobile_application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class test {
    Map<String,String> m = new HashMap<String, String>();

    public static void main(String[] args) {
        test t = new test();
        t.testmap();
    }

    public void testmap() {
        m.put("meal1", "1");
        m.put("meal2", "3");
        m.put("meal3", "5");
        for (Entry<String, String> order : m.entrySet()) {
            order.getKey();
            order.getValue();
            System.out.println(order.getKey() + "  " + order.getValue());
        }
    }
}
