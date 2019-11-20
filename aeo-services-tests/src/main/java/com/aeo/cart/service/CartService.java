package com.aeo.cart.service;

import com.aeo.beans.CartBean;

public interface CartService {
	   public abstract String addCart(CartBean cart);
	   public abstract void updateCart(String cartId, CartBean cart);
	   public abstract void deleteCart(String cartId);
	   public abstract CartBean getCart(String cartId);

}

