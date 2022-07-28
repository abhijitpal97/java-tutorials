package com.example.jpa.Configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration {
	
	
	public Executor setProperties()
	{
		ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
		exec.setCorePoolSize(2);
		exec.setMaxPoolSize(2);
		exec.setQueueCapacity(100);
		exec.setThreadNamePrefix("userThread - ");
		exec.initialize();
		
		return exec;
	}

}
