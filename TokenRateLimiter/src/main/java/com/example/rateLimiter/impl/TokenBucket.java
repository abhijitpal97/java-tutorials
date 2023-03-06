package com.example.rateLimiter.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.example.rateLimiter.RateLimiter;

/**
 * @author ap39354
 *
 */

public class TokenBucket implements RateLimiter {

	private int bucketCapacity;
	private int refreshRate;
	private AtomicInteger currentCapacity;
	private AtomicLong lastUpdateTime;



	public TokenBucket(int bucketCapacity, int refreshRate) {
		super();
		this.bucketCapacity = bucketCapacity;
		this.refreshRate = refreshRate;
		currentCapacity = new AtomicInteger(bucketCapacity);
		lastUpdateTime = new AtomicLong(System.currentTimeMillis());
	}
	@Override
	public boolean hasAccess() {
		refreshBucket();
		if(currentCapacity.get()>0)
		{
			currentCapacity.decrementAndGet();
			return true;
		}
		return false;	
	}

	private void refreshBucket() {
		long currTime = System.currentTimeMillis();
		int additionalToken = ((int)(currTime-lastUpdateTime.get())/1000) * refreshRate;
		currentCapacity.getAndSet(Math.min(bucketCapacity , (additionalToken+currentCapacity.get())));
		lastUpdateTime.getAndSet(currTime);
	}



}
