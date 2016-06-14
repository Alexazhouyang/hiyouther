package com.tool.timeLister;


import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 业务处理类
 */
public class MyJob implements Job {
	// 执行任务入口函数
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("现在的时间是: " + new Date());
	}
}
