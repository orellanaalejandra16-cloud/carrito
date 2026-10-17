package com.carrito.carrito.service;

import com.carrito.carrito.entity.CartItem;
import com.carrito.carrito.entity.Product;
import com.carrito.carrito.repository.CartRepository;
import com.carrito.carrito.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CartService cartService;

    private Product product;
    private CartItem cartItem;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("Laptop de Prueba");
        product.setPrice(750.0);

        cartItem = new CartItem(product, 2);
        cartItem.setId(1L);
    }

    @Test
    void testGetCartItems() {
        when(cartRepository.findAll()).thenReturn(Arrays.asList(cartItem));

        List<CartItem> items = cartService.getCartItems();

        assertNotNull(items);
        assertEquals(1, items.size());
        verify(cartRepository, times(1)).findAll();
    }

    @Test
    void testAddToCart() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(cartRepository.save(any(CartItem.class))).thenReturn(cartItem);

        CartItem savedItem = cartService.addToCart(1L, 2);

        assertNotNull(savedItem);
        assertEquals(2, savedItem.getQuantity());
        assertEquals("Laptop de Prueba", savedItem.getProduct().getName());
        verify(productRepository, times(1)).findById(1L);
        verify(cartRepository, times(1)).save(any(CartItem.class));
    }

    @Test
    void testRemoveFromCart() {
        doNothing().when(cartRepository).deleteById(1L);

        cartService.removeFromCart(1L);

        verify(cartRepository, times(1)).deleteById(1L);
    }
}