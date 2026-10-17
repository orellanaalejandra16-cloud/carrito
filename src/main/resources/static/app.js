const API_URL = 'http://localhost:8080/api';

document.addEventListener('DOMContentLoaded', () => {
    fetchProducts();
    fetchCart();
});

function fetchProducts() {
    fetch(`${API_URL}/products`)
        .then(response => response.json())
        .then(products => {
            const productContainer = document.getElementById('product-list');
            if (!productContainer) return;

            productContainer.innerHTML = '';
            products.forEach(product => {
                productContainer.innerHTML += `
                    <div class="product-card">
                        <img src="${product.imageUrl}" alt="${product.name}" width="120">
                        <h3>${product.name}</h3>
                        <p>Precio: $${product.price}</p>
                        <button onclick="addToCart(${product.id})">Agregar al Carrito</button>
                    </div>
                `;
            });
        })
        .catch(error => console.error('Error al listar productos:', error));
}

function addToCart(productId) {
    fetch(`${API_URL}/cart/add?productId=${productId}&quantity=1`)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('No se pudo agregar el producto');
        })
        .then(data => {
            alert('¡Producto agregado al carrito con éxito!');
            fetchCart(); // Actualizar la vista del carrito
        })
        .catch(error => console.error('Error al agregar al carrito:', error));
}

function fetchCart() {
    fetch(`${API_URL}/cart`)
        .then(response => response.json())
        .then(cartItems => {
            const cartContainer = document.getElementById('cart-list');
            if (!cartContainer) return;

            cartContainer.innerHTML = '';
            cartItems.forEach(item => {
                cartContainer.innerHTML += `
                    <div class="cart-item">
                        <span>${item.product.name} (Cantidad: ${item.quantity})</span>
                        <button onclick="removeFromCart(${item.id})">Eliminar</button>
                    </div>
                `;
            });
        })
        .catch(error => console.error('Error al cargar el carrito:', error));
}

function removeFromCart(cartItemId) {
    fetch(`${API_URL}/cart/remove/${cartItemId}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            alert('Producto eliminado del carrito');
            fetchCart();
        } else {
            alert('Error al eliminar el producto');
        }
    })
    .catch(error => console.error('Error al eliminar:', error));
}