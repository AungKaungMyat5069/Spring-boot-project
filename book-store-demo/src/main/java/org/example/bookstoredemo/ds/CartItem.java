package org.example.bookstoredemo.ds;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class CartItem {
    private Integer id;
    private String title;
    private double price;
    private String authorName;
}
