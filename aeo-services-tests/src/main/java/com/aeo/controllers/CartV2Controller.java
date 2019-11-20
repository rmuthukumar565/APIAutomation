package com.aeo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeo.beans.CartBean;
import com.aeo.cart.service.CartServiceImpl;

@RestController
public class CartV2Controller {
	@RequestMapping(value = "/v2/cart/items", method = RequestMethod.POST)
	public ResponseEntity<Object> addCart(@RequestBody CartBean cart) {
		CartServiceImpl cartService = new CartServiceImpl();
		ResponseEntity<Object> responseEntity = null;
		String cartId = cartService.addCart(cart);
		if (cartId != null) {
			cart.setCartId(cartId);
			responseEntity = new ResponseEntity<>(cart, HttpStatus.CREATED);
		} else {
			responseEntity = new ResponseEntity<>("There is an Error while processing the request", HttpStatus.OK);

		}
		return responseEntity;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/v2/cart/{cartid}")
	@ResponseBody
	public ResponseEntity<Object> getCart(@PathVariable("cartid") String cartid) {
		CartServiceImpl cartService = new CartServiceImpl();
		return new ResponseEntity<>(cartService.getCart(cartid), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/v2/cart")
	@ResponseBody
	public ResponseEntity<Object> updateCart(@RequestBody CartBean cart) {
		CartServiceImpl cartService = new CartServiceImpl();
		ResponseEntity<Object> responseEntity = null;
		if (cart.getCartId() != null && cartService.isCart(cart.getCartId())) {
			cartService.updateCart(cart.getCartId(), cart);
			responseEntity = new ResponseEntity<>("Update cart successful", HttpStatus.OK);
		}

		return responseEntity;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/v2/cart/{cartid}")
	@ResponseBody
	public ResponseEntity<Object> deleteCart(String cartid) {
		CartServiceImpl cartService = new CartServiceImpl();
		ResponseEntity<Object> responseEntity = null;
		cartService.deleteCart(cartid);
	    responseEntity = new ResponseEntity<>("Delete cart successful", HttpStatus.OK);
		return responseEntity;
	}

}
