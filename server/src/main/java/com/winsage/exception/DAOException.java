/**
 * 
 */
package com.winsage.exception;

/**
 * @author msingh
 *
 */
public class DAOException extends Exception{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 330422149431262436L;
	
	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param message the message
	 */
	public DAOException(String message)
	{
		super(message);
	}
	
	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public DAOException(String message,Exception e)
	{
		super(message);
	}
	

}
