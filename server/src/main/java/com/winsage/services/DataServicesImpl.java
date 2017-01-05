package com.winsage.services;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.winsage.configuration.ApplicationResponseCodes;
import com.winsage.constants.Constant;
import com.winsage.dao.DataDao;
import com.winsage.exception.DAOException;
import com.winsage.messages.LocaleMessageReader;
import com.winsage.model.BaseEntity;
import com.winsage.model.Products;
import com.winsage.model.JsonResponse;
import com.winsage.model.User;
import com.winsage.utility.Utils;


@Service("dataServices")
public class DataServicesImpl implements DataServices {

	@Autowired
	private DataDao dataDao;
	
	
	@Autowired
	private LocaleMessageReader localeMessageReader;
	
	private JsonResponse jsonResponse;
	
	@Override
	public JsonResponse addEntity(BaseEntity entity) throws Exception {
		try{
			boolean isEntityAdded = dataDao.addEntity(entity);
			if(isEntityAdded){
				jsonResponse = JsonResponse.instance(HttpStatus.CREATED.value(),
						localeMessageReader.getMessage(ApplicationResponseCodes.ENTITY_CREATED.getMessageKey()));
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),
					localeMessageReader.getMessage(ApplicationResponseCodes.DB_ERROR.getMessageKey()));
		}
		
		return jsonResponse;
	}

	@Override
	public JsonResponse getEntityById(long id) throws Exception {
		
		Products Products = dataDao.getEntityById(id);
		if(Products != null){
			jsonResponse = JsonResponse.instance(HttpStatus.OK.value(),Products,
					localeMessageReader.getMessage(ApplicationResponseCodes.STATUS_OK.getMessageKey()));
		}else{
			jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),null,
					localeMessageReader.getMessage(ApplicationResponseCodes.DB_ERROR.getMessageKey()));
		}
		return jsonResponse;
	}
	
	@Override
	public JsonResponse authenticateUser(User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {
		
		String sessionId = null;
		try{		
			User authenticatedUser = dataDao.authenticateUser(user);		
			if(authenticatedUser != null && authenticatedUser.getPassword().equals(user.getPassword())){			
				sessionId = Utils.generateSessionId();
				authenticatedUser.setSessionid(sessionId);
				dataDao.updateUserSession(authenticatedUser);
				Cookie cookie = new Cookie(Constant.APPLICATION_SESSION_ID, sessionId);
				cookie.setMaxAge(Constant.DEFAULT_MAX_AGE);
				cookie.setSecure(Constant.COOKIE_SECURE);
				cookie.setPath("/");
				httpResponse.addCookie(cookie);
				jsonResponse = JsonResponse.instance(HttpStatus.OK.value(),null,
						localeMessageReader.getMessage(ApplicationResponseCodes.STATUS_OK.getMessageKey()));			
			}else{
				jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),null,
						localeMessageReader.getMessage(ApplicationResponseCodes.INVALID_USER.getMessageKey()));
			}
		}catch(DAOException e){
			e.printStackTrace();
			jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),null,
					localeMessageReader.getMessage(ApplicationResponseCodes.INVALID_USER.getMessageKey()));			
		}
		catch(Exception e){
			jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),null,
					localeMessageReader.getMessage(ApplicationResponseCodes.DB_ERROR.getMessageKey()));			
		}
		return jsonResponse;
	}

	@Override
	public JsonResponse getProductList(String sessionId, int limit,  HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {		
		List<Products> ProductsList = null;
		try{
			if(sessionId != null){
				ProductsList = dataDao.getProductList(limit);
				if(ProductsList != null){
					jsonResponse = JsonResponse.instance(HttpStatus.OK.value(),ProductsList,
							localeMessageReader.getMessage(ApplicationResponseCodes.STATUS_OK.getMessageKey()));
				}
			}else{
				jsonResponse = JsonResponse.instance(localeMessageReader.getMessage(ApplicationResponseCodes.INTERNAL_SERVER_ERROR.getMessageKey()));
			}
			
		}catch(DAOException e){
			jsonResponse = JsonResponse.instance(localeMessageReader.getMessage(ApplicationResponseCodes.DB_ERROR.getMessageKey()));
		}catch(Exception e){
			e.printStackTrace();
			jsonResponse = JsonResponse.instance(HttpStatus.INTERNAL_SERVER_ERROR.value(),null,
					localeMessageReader.getMessage(ApplicationResponseCodes.INTERNAL_SERVER_ERROR.getMessageKey()));
		}	
		
		return jsonResponse;
	}
	
	@Override
	public JsonResponse saveUser(User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {
				
		try{		
			Long userId = dataDao.saveUser(user);		
			jsonResponse = JsonResponse.instance(HttpStatus.OK.value(),userId,
					localeMessageReader.getMessage(ApplicationResponseCodes.STATUS_OK.getMessageKey()));
		}catch(Exception e){
			jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),null,
					localeMessageReader.getMessage(ApplicationResponseCodes.DB_ERROR.getMessageKey()));			
		}
		return jsonResponse;
	}
	
	@Override
	public JsonResponse updateCatalogDetails(Long catalogId, Products Products, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception {
				
		try{		
			Long userId = dataDao.updateCatalogDetails(catalogId, Products);		
			/*if(user != null && authenticatedUser.getPassword().equals(user.getPassword())){			
				sessionId = Utils.generateSessionId();
				authenticatedUser.setSessionid(sessionId);
				dataDao.updateUserSession(authenticatedUser);
				Cookie cookie = new Cookie(Constant.APPLICATION_SESSION_ID, sessionId);
				cookie.setMaxAge(Constant.DEFAULT_MAX_AGE);
				cookie.setSecure(Constant.COOKIE_SECURE);
				cookie.setPath("/");
				httpResponse.addCookie(cookie);
				jsonResponse = JsonResponse.instance(HttpStatus.OK.value(),null,
						localeMessageReader.getMessage(ApplicationResponseCodes.STATUS_OK.getMessageKey()));			
			}*/	
			jsonResponse = JsonResponse.instance(HttpStatus.OK.value(),userId,
					localeMessageReader.getMessage(ApplicationResponseCodes.STATUS_OK.getMessageKey()));
		}catch(Exception e){
			jsonResponse = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),null,
					localeMessageReader.getMessage(ApplicationResponseCodes.DB_ERROR.getMessageKey()));			
		}
		return jsonResponse;
	}
	
	
	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
