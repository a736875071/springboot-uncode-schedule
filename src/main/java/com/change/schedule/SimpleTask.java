package com.change.schedule;

import org.springframework.stereotype.Component;

/**
 * @author YangQ
 * @date 2020/3/17 17:04
 */
@Component
public class SimpleTask {

    private static int i = 0;

    public void print() {
        System.out.println("===========start!=========");
        System.out.println("I:" + i);
        i++;
        System.out.println("=========== end !=========");
    }
}
