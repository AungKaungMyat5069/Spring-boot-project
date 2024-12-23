package org.example.securitymaster.annotation;


import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Secured("ROLE_SUPER_ADMIN")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SuperAdmin {
}
