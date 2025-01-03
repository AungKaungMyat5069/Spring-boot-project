package org.example.bloggendemo.entity.info;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class ClassId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
