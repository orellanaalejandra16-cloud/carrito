package com.carrito.carrito.service;

import com.carrito.carrito.entity.CartItem;
import com.carrito.carrito.entity.Product;
import com.carrito.carrito.repository.CartRepository;
import com.carrito.carrito.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }

    public CartItem addToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        CartItem cartItem = new CartItem(product, quantity);
        return cartRepository.save(cartItem);
    }

    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }
}