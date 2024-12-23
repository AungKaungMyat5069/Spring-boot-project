package org.example.springmvcscope.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@Getter
@Setter
@ApplicationScope
public class ApplicationScopeBean {

    private int applicationScopeCount;
}
