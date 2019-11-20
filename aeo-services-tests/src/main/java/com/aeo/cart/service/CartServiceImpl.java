package com.aeo.cart.service;

import java.util.HashMap;
import java.util.Map;


import com.aeo.beans.CartBean;

public class CartServiceImpl implements CartService{
	private static Map<String, CartBean> cartDB = new HashMap<>();

	@Override
	public String addCart(CartBean cart) {
		String cartId = null;
		if (cart.getProductId() != null && cart.getQty() != 0 && cart.getSkuId() != null) {		
			cartId = generateUniqueCartId();
				cartDB.put(cartId, cart);			
						
		} 

		return cartId;

	}

	@Override
	public void updateCart(String cartId, CartBean cart) {
		if (cartDB.containsKey(cartId)) {
			cartDB.remove(cartId);
			cartDB.put(cartId, cart);
		} else
			cartDB.put(cartId, cart);

	}

	@Override
	public void deleteCart(String cartId) {
		if (cartDB.containsKey(cartId)) {
			cartDB.remove(cartId);
		}

	}

	@Override
	public CartBean getCart(String cartId) {

		return cartDB.get(cartId);

	}

	private String generateUniqueCartId() {
		int cartId = (int) (Math.random() * 9000) + 1000;
		String uniqueCartId = String.valueOf(cartId);
		return uniqueCartId;
	}

	public boolean isCart(String cartId) {
		return cartDB.containsKey(cartId);

	}


}
