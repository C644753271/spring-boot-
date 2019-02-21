//package com.duoqio.cloud.task.quartz.test;
//
//import org.quartz.DisallowConcurrentExecution;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//@DisallowConcurrentExecution // 不允许并发执行
//public class JobTest extends QuartzJobBean {
//
//	@Override
//	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//		System.out.println(context.getJobDetail().getKey());
//	}
//
//}
