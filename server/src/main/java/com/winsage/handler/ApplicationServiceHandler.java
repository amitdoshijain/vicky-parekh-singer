/**
 * 
 */
package com.winsage.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winsage.configuration.RestAction;
import com.winsage.model.Products;
import com.winsage.model.JsonResponse;
import com.winsage.model.ParamVO;

/**
 * @author msingh
 *
 */
public interface ApplicationServiceHandler {
	
	public JsonResponse process(RestAction action, ParamVO paramVO, HttpServletRequest httpRequest, HttpServletResponse httpResponse);

}
