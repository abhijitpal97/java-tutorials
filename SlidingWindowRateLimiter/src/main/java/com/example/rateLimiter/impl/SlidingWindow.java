package com.example.rateLimiter.impl;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.example.rateLimiter.RateLimiter;

/**
 * @author ap39354
 *
 */

public class SlidingWindow implements RateLimiter {

	Queue<Long> sliding;
	int timeWindowFrame;
	int bucketCapacity;

	public SlidingWindow(int bucketCapacity , int timeWindowFrame)
	{
		this.bucketCapacity=bucketCapacity;
		this.timeWindowFrame=timeWindowFrame;
		sliding = new ConcurrentLinkedQueue<>();
	}

	@Override
	public boolean hasAccess() {
		long currentTime = System.currentTimeMillis();
		checkAndRemoveAccessLog(currentTime);
		if(sliding.size()<bucketCapacity)
		{
			sliding.offer(currentTime);
			return true;
		}

		return false;
	}

	private void checkAndRemoveAccessLog(long currentTime) {
		if(sliding.isEmpty()) return;

		long tillCheck = (currentTime - sliding.peek()) /1000;
		while(tillCheck>timeWindowFrame)
		{
			sliding.poll();
			if(sliding.isEmpty()) break;
			tillCheck = (currentTime - sliding.peek()) /1000;
		}
	}



}
