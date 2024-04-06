//package com.hmblogs.backend.util;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//public class MyScheduler {
//    public static void main(String[] args) throws SchedulerException {
//        //创建调度器Schedule
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = schedulerFactory.getScheduler();
//        //创建JobDetail实例，并与HelloWordJob类绑定
//        JobDetail jobDetail = JobBuilder.newJob(HelloWorldQuartzJob.class)
//                .withIdentity("job1","jobGroup1").build();
//        /*创建触发器Trigger实例（立即执行，5秒后执行一次）；withRepeatCount(1)：5秒后执行，只执行一次
//        RepeatForever：指定触发器将无限期重复，每隔5秒都执行一次*/
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1","triggerGroup1")
//                .startNow()
//                .withSchedule( SimpleScheduleBuilder.simpleSchedule()
//                        .withIntervalInSeconds(5).repeatForever()).build();
//        //开始执行
//        scheduler.scheduleJob(jobDetail,trigger);
//        scheduler.start();
//    }
//}
//
