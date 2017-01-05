package com.winsage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winsage.configuration.RestAction;
import com.winsage.constants.Constant;
import com.winsage.handler.ApplicationServiceHandler;
import com.winsage.model.JsonResponse;
import com.winsage.model.ParamVO;
import com.winsage.model.Products;
import com.winsage.model.User;
import com.winsage.services.DataServices;

@Controller
@RequestMapping("/")
public class RestController {

	@Autowired
	DataServices dataServices;
	
	@Autowired
	private ApplicationServiceHandler applicationServiceHandler;
	
	@Autowired
	private ParamVO paramVO;

	static final Logger logger = Logger.getLogger(RestController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse loginAuthentication(@RequestBody User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse){
		
		paramVO.setUserVO(user);		
		return applicationServiceHandler.process(RestAction.AUTHENTICATE_USER, paramVO, httpRequest, httpResponse);
		
	}
	

	@RequestMapping(value = "/product", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	JsonResponse addProduct(@RequestBody Products product, HttpServletRequest httpRequest, HttpServletResponse httpResponse)throws Exception {	
		paramVO.setProducts(product);	
		return applicationServiceHandler.process(RestAction.SAVE_PRODUCT_DETAILS, paramVO, httpRequest, httpResponse);
		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	JsonResponse addUser(@RequestBody User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse)throws Exception {	
		paramVO.setUserVO(user);	
		return applicationServiceHandler.process(RestAction.SAVE_USER, paramVO, httpRequest, httpResponse);
		
	}

	@RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	JsonResponse getProduct(@CookieValue(value=Constant.APPLICATION_SESSION_ID, required=false) String sessionId, @PathVariable("id") long id, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		paramVO.setId(id);		
		return applicationServiceHandler.process(RestAction.GET_PRODUCT_DETAILS, paramVO, httpRequest, httpResponse);
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse getCatalogsList(@CookieValue(value=Constant.APPLICATION_SESSION_ID, required=false) String sessionId, @RequestParam(value=Constant.TRANSACTION_LIMIT) int limit,HttpServletRequest httpRequest, HttpServletResponse httpResponse) {

		paramVO.setLimit(limit);
		paramVO.setSessionid(sessionId);		
		return applicationServiceHandler.process(RestAction.GET_PRODUCT_LIST, paramVO, httpRequest, httpResponse);		
	}
	
	@RequestMapping(value = "/catalog/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	JsonResponse updateProduct(@RequestBody Products product, @PathVariable("id") Long id,HttpServletRequest httpRequest, HttpServletResponse httpResponse)throws Exception {	
		paramVO.setId(id);		
		paramVO.setProducts(product);		
		return applicationServiceHandler.process(RestAction.UPDATE_CATALOG_DETAILS, paramVO, httpRequest, httpResponse);
		
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse deleteProduct(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new JsonResponse(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new JsonResponse(0, e.toString());
		}

	}
}
