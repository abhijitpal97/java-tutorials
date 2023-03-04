package com.example.driver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.rateLimiter.user.BucketCreator;

public class Main {

	public static void main(String[] args) {
		BucketCreator bucket1 = new BucketCreator(1, 10 , 10);
		BucketCreator bucket2 = new BucketCreator(2, 5 , 5);
		bucket2.accessValidation(2);
		ExecutorService executor  = Executors.newFixedThreadPool(5);
		for(int i=0;i<12;i++)
		{
			executor.execute(
					() -> bucket1.accessValidation(1));
		}

		executor.shutdown();
	}

}
