package com.example.rateLimiter.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.example.rateLimiter.RateLimiter;

/**
 * @author ap39354
 * @implNote
 * Blocking Queue - It handles the request size comparing to teh blocking queue size. Also this is a thread safe as its a concurrent package.
 *
 */

public class LeakyBucket implements RateLimiter {
	
	BlockingQueue<String> bq;
	
	public LeakyBucket(int capacity)
	{
		bq = new LinkedBlockingQueue<>(capacity);
	}

	@Override
	public boolean hasAccess() {
		if(bq.remainingCapacity() > 0)
		{
			bq.add("Request Added");
			return true;
		}
		return false;	
	}
	
	

}
