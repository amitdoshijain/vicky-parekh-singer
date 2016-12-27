package com.winsage.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winsage.model.BaseEntity;
import com.winsage.model.Events;
import com.winsage.model.Products;
import com.winsage.model.Status;
import com.winsage.services.DataServices;

@Controller
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(ProductRestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addProduct(@RequestBody Products product) {
		try {
			dataServices.addEntity(product);
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	BaseEntity getProduct(@PathVariable("id") long id) {
		BaseEntity product = null;
		try {
			product = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Products> getProducts() {

		List<Products> productList = null;
		try {
			productList = (List<Products>)dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteProduct(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
