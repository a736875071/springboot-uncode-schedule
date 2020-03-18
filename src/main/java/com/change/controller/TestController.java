package com.change.controller;

import cn.uncode.schedule.ConsoleManager;
import cn.uncode.schedule.core.TaskDefine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author YangQ
 * @date 2020/3/17 13:43
 */
@RestController
public class TestController {
    @RequestMapping(value = "/add")
    public void unCodeSchedule(String key, String start) {
        TaskDefine taskDefine = new TaskDefine();
        taskDefine.setTargetBean("simpleTask");
        taskDefine.setTargetMethod("print");
        taskDefine.setExtKeySuffix("start_" + key);
        taskDefine.setStartTime(localDateTime2Date(start));
        taskDefine.setParams(key);
        taskDefine.setType(TaskDefine.TYPE_UNCODE_SINGLE_TASK);
        ConsoleManager.addScheduleTask(taskDefine);
    }

    private Date localDateTime2Date(String local) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(local, df);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }
}
