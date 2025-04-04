package com.DeepaksProject.foodapi.service;

import com.DeepaksProject.foodapi.io.CartRequest;
import com.DeepaksProject.foodapi.io.CartResponse;

public interface CartService {

    CartResponse addToCart(CartRequest request);

    CartResponse getCart();

    void clearCart();

    CartResponse removeFromCart(CartRequest cartRequest);
}
