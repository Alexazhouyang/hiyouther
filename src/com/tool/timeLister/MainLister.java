package com.tool.timeLister;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * @author forvoid
 * 定时器启动系统
 * 开启多线程执行
 * */
public class MainLister implements Job{
	//开启多线程
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
	}

}
