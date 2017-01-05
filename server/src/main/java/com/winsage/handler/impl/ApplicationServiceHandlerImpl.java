/**
 * 
 */
package com.winsage.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.winsage.configuration.RestAction;
import com.winsage.handler.ApplicationServiceHandler;
import com.winsage.model.JsonResponse;
import com.winsage.model.ParamVO;
import com.winsage.services.DataServices;

/**
 * @author msingh
 *
 */
@Component("applicationServiceHandler")
public class ApplicationServiceHandlerImpl implements ApplicationServiceHandler {

	@Autowired
	private DataServices dataServices;
	//private JsonResponse jsonResponse;
	
	@Override
	public JsonResponse process(RestAction action, ParamVO paramVO, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		// TODO Auto-generated method stub
		JsonResponse jsonResponse = null;
		switch(action){
		
		case SAVE_PRODUCT_DETAILS:			
			try {
				if(paramVO != null && paramVO.getProducts() != null){
					jsonResponse = dataServices.addEntity(paramVO.getProducts());
				}				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			break;
			
		case GET_PRODUCT_DETAILS:
			try {
				jsonResponse = dataServices.getEntityById(paramVO.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case AUTHENTICATE_USER:
			try {
				jsonResponse = dataServices.authenticateUser(paramVO.getUserVO(), httpRequest, httpResponse);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case UPDATE_CATALOG_DETAILS:
			try {
				jsonResponse = dataServices.updateCatalogDetails(paramVO.getId(), paramVO.getProducts(), httpRequest, httpResponse);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case SAVE_USER:
			try {
				jsonResponse = dataServices.saveUser(paramVO.getUserVO(), httpRequest, httpResponse);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case GET_PRODUCT_LIST:
			try {
				jsonResponse = dataServices.getProductList(paramVO.getSessionid(), paramVO.getLimit(),  httpRequest, httpResponse);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case GET_DELTA_TRANSACTION:
			try {
				//jsonResponse = dataServices.getDeltaTransaction(paramVO.getLimit(), paramVO.getStatus(), httpRequest, httpResponse);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
			default:
				System.out.println("default method");
		
		}
		return jsonResponse;
	}

	


}
