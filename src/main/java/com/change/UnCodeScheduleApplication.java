package com.change;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author YangQ
 * @date 2020/2/13 10:06
 */
@SpringBootApplication
@ComponentScan({"cn.uncode.schedule","com.change"})
public class UnCodeScheduleApplication {
    public static void main(String[] agrs) {
        SpringApplication.run(UnCodeScheduleApplication.class, agrs);
    }
}
