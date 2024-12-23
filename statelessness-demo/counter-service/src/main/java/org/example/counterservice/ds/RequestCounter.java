package org.example.counterservice.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RequestCounter {

    private int counter;

    public RequestCounter(@JsonProperty("counter") int counter) {
        this.counter = counter;

    }
}
