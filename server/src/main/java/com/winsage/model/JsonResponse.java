package com.winsage.model;

public class JsonResponse {

	private int code;
	private String message;
	private Object data;

	public JsonResponse() {
	}

	public JsonResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public JsonResponse(String message) {
		this.message = message;
	}
	
	public JsonResponse(int code, Object data, String message) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	} 

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static JsonResponse instance(int code, String message)
	{
		return new JsonResponse(code,message);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static JsonResponse instance(int code, Object data, String message)
	{
		return new JsonResponse(code, data, message);
	}
	public static JsonResponse instance(String message)
	{
		return new JsonResponse(message);
	}
}
