package org.example.affablebeanbackend.controller;


import lombok.RequiredArgsConstructor;
import org.example.affablebeanbackend.dto.OrderDetailDto;
import org.example.affablebeanbackend.dto.ProductDto;
import org.example.affablebeanbackend.service.ProductService;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affableBean")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{id}")
    public List<ProductDto> getProductByCategoryId(@PathVariable(name = "id") Integer id) {
        return productService.getProductsByCategoryId(id);
    }

    @PostMapping("/save-order")
    public ResponseEntity<String > saveOrder(@RequestBody OrderDetailDto orderDetailDto) {

        productService.saveOrderProducts(orderDetailDto);
        return ResponseEntity.ok().body("Success");
    }
}
