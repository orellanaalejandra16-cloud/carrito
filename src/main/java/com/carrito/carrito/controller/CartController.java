package com.carrito.carrito.controller;

import com.carrito.carrito.entity.CartItem;
import com.carrito.carrito.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCartItems();
    }


    @GetMapping("/add")
    public CartItem addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        return cartService.addToCart(productId, quantity);
    }

    @DeleteMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }
}