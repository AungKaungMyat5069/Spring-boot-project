package org.example.zoodb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cage extends IdClass{

    private String cageNo;
    private String location;
    @OneToOne
    private Animal animal;

    public Cage(String cageNo, String location) {
        this.cageNo = cageNo;
        this.location = location;
    }
}
