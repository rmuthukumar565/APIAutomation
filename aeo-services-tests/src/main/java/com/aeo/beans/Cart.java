package com.aeo.beans;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<String, CartInfo> cartMap;
	private static Cart cart = null;
	

	private Cart() {
		cartMap = new HashMap<String, CartInfo>();
		

	}

	public static Cart getInstance() {
		if (cart == null) {
			cart = new Cart();
			return cart;
		} else {
			return cart;
		}
	}

	public CartInfo addCart(CartInfo cartInfo) {
		String cartId = generateUniqueCartId();
		CartInfo cartStatus = new CartInfo();
		if (cartInfo.getProductId() != null && cartInfo.getQty() != 0 && cartInfo.getSkuId() != null) {
			if (!cartMap.containsKey(cartId)) {
				cartMap.put(cartId, cartInfo);
				cartStatus.setCartId(cartId);
				cartStatus.setSuccessMsg("Add Item Successful");
			}
		} else {
			cartStatus.setErrorMessage("There is an error while processing the request");
		}
		return cartStatus;
	}

	public CartInfo updateCart(CartInfo cartInfo) {
		CartInfo cartStatus = new CartInfo();
		if (cartInfo.getCartId() != null) {
			if (cartMap.containsKey(cartInfo.getCartId())) {
				cartMap.put(cartInfo.getCartId(), cartInfo);
				cartStatus.setSuccessMsg("Updated item successfully");

			} else
				cartStatus.setErrorMessage("Invalid Cart ID passed in the request");

		} else {
			cartStatus.setErrorMessage("cart id is missing in the request");

		}
		return cartStatus;
	}

	public CartInfo getCart(String cartId) {
		CartInfo cartStatus = new CartInfo();
		if (cartId != null && cartMap.containsKey(cartId)) {
			return cartMap.get(cartId);
		} else {
			cartStatus.setErrorMessage("Invalid CartId");
			return cartStatus;
		}

	}

	public CartInfo deleteCart(String cartId) {
		CartInfo cartStatus = new CartInfo();
		if (cartId != null && cartMap.containsKey(cartId)) {
			cartMap.remove(cartId);
			cartStatus.setSuccessMsg("Delete item successful");
			
		} else {
			
			cartStatus.setErrorMessage("invalid cart id");
		}
		return cartStatus;

	}

	private String generateUniqueCartId() {
		int cartId = (int) (Math.random() * 9000) + 1000;
		String uniqueCartId = String.valueOf(cartId);
		return uniqueCartId;
	}

}
