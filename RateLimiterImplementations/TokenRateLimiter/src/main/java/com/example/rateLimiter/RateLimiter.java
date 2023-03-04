/**
 * 
 */
package com.example.rateLimiter;

/**
 * @author ap39354
 * @implNote Grant Access to validate if the request is allowed to be processed.
 *
 */
public interface RateLimiter {
	boolean hasAccess();

}
