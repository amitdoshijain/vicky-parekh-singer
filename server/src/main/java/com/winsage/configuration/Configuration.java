package com.winsage.configuration;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Configuration 
{
	private static Logger log = Logger.getLogger(Configuration.class);
	private static Context context = null;
	static
	{
		try
		{
			context = new InitialContext();
		}
		catch(Exception e)
		{
			log.error("Error occured : " + e);
		}
		
		
	}
	
	public static String getParam(String name)
	{
		try
		{
			String toret = (String) context.lookup("java:comp/env/"+name);
			return toret;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public static String getParam(String name, String defaultvalue) 
	{
		try
		{
			String toret = (String) context.lookup("java:comp/env/"+name);
			return toret;
		}
		catch(Exception e)
		{
			return defaultvalue;
		}
	}
	
	public static boolean getBooleanParam(String name, boolean defaultvalue) 
	{
		try
		{
			String toret = (String) context.lookup("java:comp/env/"+name);
			if(toret.equals("true")||toret.equals("1"))
			{
				return true;
			}
			else if(toret.equals("false")||toret.equals("0"))
			{
				return false;
			}
			return defaultvalue;
		}
		catch(Exception e)
		{
			return defaultvalue;
		}
	}
}
