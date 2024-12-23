package org.example.affablebeandemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct extends IdClass{
    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private CustomerOrder customerOrder;
}
