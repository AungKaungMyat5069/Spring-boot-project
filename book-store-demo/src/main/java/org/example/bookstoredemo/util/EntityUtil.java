package org.example.bookstoredemo.util;


import org.example.bookstoredemo.ds.CartItem;
import org.example.bookstoredemo.entity.Book;

public class EntityUtil {
    public static CartItem bookToCartItem(Book book) {
        return new CartItem(book.getId(), book.getTitle(), book.getPrice(),
                book.getAuthor().getFirstName().concat(" ").concat(book.getAuthor().getLastName()));
    }
}
