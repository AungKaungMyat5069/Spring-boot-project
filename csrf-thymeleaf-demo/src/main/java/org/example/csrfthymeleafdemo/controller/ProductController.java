package org.example.csrfthymeleafdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("/add-product")
    public String addProduct(@RequestParam("name") String name) {

        logger.info("add product called{}", name);

        return "main";
    }
}
