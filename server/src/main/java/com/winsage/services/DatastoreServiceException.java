package com.winsage.services;

public class DatastoreServiceException extends Exception {

	public DatastoreServiceException(String string, Exception e) 
	{
		super(string,e);
	}

}
