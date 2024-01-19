package com.db.squaremile;

import java.util.concurrent.ScheduledExecutorService;

import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import io.micrometer.context.ContextScheduledExecutorService;

public class ScheduleConfig {
	static class TracedThreadPoolTaskScheduler extends ThreadPoolTaskScheduler {

	    @Override
	    public ScheduledExecutorService getScheduledExecutor() throws IllegalStateException {
	      return ContextScheduledExecutorService.wrap(super.getScheduledExecutor());
	    }
	  }

	  @Bean
	  public ThreadPoolTaskScheduler taskScheduler(TaskSchedulerBuilder builder) {
	    return builder.configure(new TracedThreadPoolTaskScheduler());
	  }

}
