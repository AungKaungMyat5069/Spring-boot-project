package org.example.bloggendemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bloggendemo.entity.info.ClassId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Setter @Getter
@NoArgsConstructor
public class Post extends ClassId {

    private String title;
    @Column(columnDefinition = "text")
    private String body;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePosted;

    // when we write the letter the body, may be 100 or can be more that is why we have to use
    // @Column(columnDefinition = "text"

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;
}
