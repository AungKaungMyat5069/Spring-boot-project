package org.example.bookstorebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {

    private Integer bookId;

    private String title;
    private Double price;
    private String imgUrl;

    private String categoryName;

    private String firstName;
    private String lastName;
    private String email;
}
