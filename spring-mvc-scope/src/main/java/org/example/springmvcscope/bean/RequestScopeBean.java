package org.example.springmvcscope.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Setter
@RequestScope
@Component
public class RequestScopeBean {

    private int requestCount;
}
