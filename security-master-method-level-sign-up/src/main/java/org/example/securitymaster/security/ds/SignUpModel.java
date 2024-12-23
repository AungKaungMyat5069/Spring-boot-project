package org.example.securitymaster.security.ds;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpModel {

    @NotBlank(message = "this field can not be blank")
    private String username;
    @NotBlank(message = "this field can not be blank")
    private String password;
    private String roles;
}
