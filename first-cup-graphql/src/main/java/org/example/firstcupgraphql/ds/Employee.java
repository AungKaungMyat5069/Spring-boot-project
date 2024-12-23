package org.example.firstcupgraphql.ds;

public record Employee(
        Integer id,
        String firstName,
        String lastName,
        Double salary,
        String job
) {
}
