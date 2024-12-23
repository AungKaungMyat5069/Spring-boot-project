package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Method 3
// 1. add Configuration
// 2. add ComponentScan
// 3. add Component to transfer ioc
// basePackage's default is current package
// if Your component is other package you have to modify that

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfigMethod3 {

}
