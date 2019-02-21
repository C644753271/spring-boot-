//package com.duoqio.cloud.task.quartz.test;
//
//import org.quartz.CronScheduleBuilder;
//import org.quartz.JobBuilder;
//import org.quartz.JobDetail;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//	@Bean
//	public JobDetail jobDetail(){
//		//定义作业的实例
//		JobDetail jobDetail = JobBuilder.newJob(JobTest.class)
//				.withIdentity("a","b") //设置name/group
//				.usingJobData("c", "d") //JobDataMap可以给任务传递参数
//				.storeDurably()
//				.build();
//		return jobDetail;
//	}
//	
//	@Bean
//	public Trigger trigger(){
//		//创建Trigger触发器设置使用cronSchedule方式调度
//		Trigger trigger = TriggerBuilder.newTrigger()
//				.forJob(jobDetail()) 
//				.withIdentity("e", "f") //设置name/group
//				.usingJobData("g", "h") //JobDataMap可以给任务传递参数
//				.startNow()
//				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
//				.build();
//		return trigger;
//	}
//	
//	
//}
