package com.aeo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeo.beans.Cart;
import com.aeo.beans.CartInfo;

@RestController
public class CartConroller {
	
	

	@RequestMapping(method = RequestMethod.POST, value = "/v1/cart/item")
	@ResponseBody
	public CartInfo addCart(@RequestBody CartInfo cartInfo) {
		CartInfo cartResponse = new CartInfo();
		CartInfo cart = Cart.getInstance().addCart(cartInfo);
		if (cartInfo.getErrorMessage() == null) {
			cartResponse.setCartId(cart.getCartId());
			cartResponse.setSuccessMsg(cart.getSuccessMsg());
		}else {
			cartResponse.setSuccessMsg(cart.getErrorMessage());
		}
		
		return cartResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/v1/cart/{cartid}")
	@ResponseBody
	public CartInfo getCart(@PathVariable("cartid") String cartid) {
		CartInfo getCartResponse = new CartInfo();
		CartInfo cartInfo = Cart.getInstance().getCart(cartid);
		if (cartInfo.getErrorMessage() == null) {
			getCartResponse.setCartId(cartInfo.getCartId());
			getCartResponse.setProductId(cartInfo.getProductId());
			getCartResponse.setSkuId(cartInfo.getSkuId());
			getCartResponse.setQty(cartInfo.getQty());
		} else {
			getCartResponse.setErrorMessage(cartInfo.getErrorMessage());
		}
		return getCartResponse;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/v1/cart")
	@ResponseBody
	public CartInfo updateCart(@RequestBody CartInfo cartInfo) {
		CartInfo updateCartRespBean = new CartInfo();
		CartInfo updateCartResponse = Cart.getInstance().updateCart(cartInfo);
		if (updateCartResponse.getErrorMessage() != null) {
			updateCartRespBean.setErrorMessage(updateCartResponse.getErrorMessage());

		} else {
			updateCartRespBean.setSuccessMsg(updateCartResponse.getErrorMessage());
		}
		return updateCartRespBean;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/v1/cart/{cartid}")
	@ResponseBody
	public CartInfo deleteCart(@PathVariable("cartid") String cartid) {
		CartInfo removeCartRespBean = new CartInfo();
		CartInfo removeCartResponse = Cart.getInstance().deleteCart(cartid);
		if (removeCartResponse.getErrorMessage() != null) {
			removeCartRespBean.setErrorMessage(removeCartResponse.getErrorMessage());
		} else {
			removeCartRespBean.setSuccessMsg(removeCartResponse.getSuccessMsg());
		}
		return removeCartRespBean;

	}
}
