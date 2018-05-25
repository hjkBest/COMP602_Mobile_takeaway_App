package com.example.user.comp602_restaurant_mobile_application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class test {
    Map<String,String> m = new HashMap<String, String>();
    String orderstr = "";
    int total = 10;
    public static void main(String[] args) {
        test t = new test();
        t.testmap();
    }

    public void testmap() {
        m.put("meal1", "1");
        m.put("meal2", "3");
        m.put("meal3", "5");
        for (Entry<String, String> order : m.entrySet()) {
            String str1 = order.getKey();
            String str2 = order.getValue();
            orderstr = orderstr + str1 + " " + str2 + "\n";

        }
        orderstr = orderstr + "$: " + total + "\n";
        System.out.print(orderstr);
    }
}
