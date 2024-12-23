package org.example.springmvcscope.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class SessionScopeBean {
    private int sessionCount;
}
