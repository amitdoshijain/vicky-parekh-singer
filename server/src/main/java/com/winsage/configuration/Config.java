package com.winsage.configuration;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Config 
{
	private static Log log = LogFactory.getLog(Config.class);
	private static Context context = null;
	private static Context envcontext = null;
	static
	{
		try
		{
			context = new InitialContext();
		}
		catch(Exception e)
		{
			log.error("Error",e);
			e.printStackTrace();
		}
		try
        {
        	setEnvcontext((Context) context.lookup("java:comp/env"));
        }
		catch(Exception e)
		{
			log.error("Error",e);
			e.printStackTrace();
		}
	}
	
	public static String getParam(String name)
	{
		try
		{
			String toret = (String) context.lookup("java:comp/env/"+name);
			log.debug("getParam : " + name + " : " + toret);
			return toret;
		}
		catch(Exception e)
		{
			log.debug("getParam : " + name + " : " + null);
			return null;
		}
	}

	public static Context getEnvcontext() {
		return envcontext;
	}

	public static void setEnvcontext(Context envcontext) {
		Config.envcontext = envcontext;
	}
}
