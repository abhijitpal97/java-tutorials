package com.example.rateLimiter.user;

import java.util.HashMap;
import java.util.Map;

import com.example.rateLimiter.impl.LeakyBucket;

/**
 * @author ap39354
 * @implNote
 * This class is handling the user creation with each having a capacity rate Limit.
 *
 */

public class BucketCreator {
	Map<Integer, LeakyBucket> map;
	
	public BucketCreator(int id , int capacity)
	{
		map = new HashMap<>();
		map.put(id, new LeakyBucket(capacity));
	}

	public void accessValidation(int id)
	{
		if(map.get(id).hasAccess())
		{
			System.out.println("Bucket has size and User - "+id+" is able to access the system. Acccessed System - "+Thread.currentThread().getName());
		}
		else
		{
			System.out.println("Too man requests to process for User - "+id+". Please try after sometime.");
		}
	}

}
