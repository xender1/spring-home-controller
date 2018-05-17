package com.kcprojects.mainsite;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBeanObject {

    private int simpleCount = 0;

    public int getCount() {
        return simpleCount;
    }

    public void increaseCount() {
        simpleCount++;
    }
}
 