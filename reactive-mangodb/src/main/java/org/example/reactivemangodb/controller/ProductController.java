package org.example.reactivemangodb.controller;

import lombok.RequiredArgsConstructor;
import org.example.reactivemangodb.dto.ProductDto;
import org.example.reactivemangodb.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDto> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<ResponseEntity<ProductDto>> getProduct(@RequestParam("id") String id) {
        return productService.getProduct(id)
                .map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @DeleteMapping
    public Mono<Void> deleteProduct(@RequestParam("id") String id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{updateId}")
    public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable("updateId") String id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


}
