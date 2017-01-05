/**
 * 
 */
package com.winsage.utility;

import java.util.UUID;

/**
 * @author msingh
 *
 */
public class Utils {
	
	public static String generateSessionId(){
		
		String sessionId = UUID.randomUUID().toString();
		
		return sessionId;
		
	}

}
