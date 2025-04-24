package org.example.affablebeanui.services;

import org.example.affablebeanui.dto.CartDto;
import org.example.affablebeanui.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class CartService {

    private final ProductService productService;

    private HashSet<CartDto> carts = new HashSet<>();

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public void addCart(Integer id) {
        this.carts.add(getCartByProductId(id));
    }

    private CartDto getCartByProductId(Integer productId) {
        ProductDto productDto = productService.getAllProducts()
                .stream()
                .filter(p -> Objects.equals(p.getId(), productId))
                .findFirst().orElse(null);
        assert productDto != null;
        return new CartDto(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                1
        );
    }

    public Set<CartDto> getCarts() {
        return carts;
    }

    public int cartCount() {
        return carts.size();
    }


    public void removeCart(Integer id) {
        this.carts.remove(getCartByProductId(id));
    }

    public void clearCart() {
        this.carts.clear();
    }
}
