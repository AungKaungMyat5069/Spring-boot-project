package org.example.reactivedem.ds;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class Response {
    private Date date = new Date();
    private int output;

    public Response(int output) {
        this.output = output;
    }


}
