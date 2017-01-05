package com.winsage.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winsage.model.BaseEntity;
import com.winsage.model.JsonResponse;
import com.winsage.model.Products;
import com.winsage.model.User;

public interface DataServices {
	public JsonResponse addEntity(BaseEntity entity) throws Exception;
	public JsonResponse getEntityById(long id) throws Exception;
	public JsonResponse getProductList(String sessionId, int limit, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public JsonResponse authenticateUser(User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception;
	public JsonResponse saveUser(User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception;
	public JsonResponse updateCatalogDetails(Long catalogId, Products Products, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception;
}
