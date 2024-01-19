package com.db.squaremile;

import java.util.concurrent.Executor;

import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import io.micrometer.context.ContextExecutorService;
import io.micrometer.context.ContextSnapshot;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AsyncTraceContextConfig implements AsyncConfigurer{
	private final ThreadPoolTaskExecutor taskExecutor;

	  @Override
	  public Executor getAsyncExecutor() {
	    return ContextExecutorService.wrap(
	        taskExecutor.getThreadPoolExecutor(), ContextSnapshot::captureAll);
	  }

}
