package org.example.bookstoredemo.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.bookstoredemo.dao.BookDao;
import org.example.bookstoredemo.ds.CartItem;
import org.example.bookstoredemo.entity.Book;
import org.example.bookstoredemo.util.EntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service @SessionScope
@RequiredArgsConstructor
public class CartService {
    private final BookDao bookDao;
    @Getter
    private Set<CartItem> cartItems = new HashSet<>();

    public void addCartItem(Integer id) {
        Book book = bookDao.findById(id).get();
        cartItems.add(EntityUtil.bookToCartItem(book));
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public double totalPrice() {
       return cartItems.stream().map(CartItem::getPrice).reduce(0.0, Double::sum);
    }

    public void removeCartItem(Integer id) {
        this.cartItems.stream().filter(item -> item.getId() == id).findFirst().ifPresent(item -> cartItems.remove(item));
    }

}
