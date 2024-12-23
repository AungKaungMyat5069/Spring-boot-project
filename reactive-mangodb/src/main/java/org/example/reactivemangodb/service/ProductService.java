package org.example.reactivemangodb.service;

import lombok.RequiredArgsConstructor;
import org.example.reactivemangodb.dao.ProductDao;
import org.example.reactivemangodb.dto.ProductDto;
import org.example.reactivemangodb.util.EntityUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;



    public Flux<ProductDto> getProducts() {
        return productDao.findAll().map(EntityUtil::toProductDto);
    }

    public Mono<ProductDto> getProduct(String id) {
        return productDao.findById(id).map(EntityUtil::toProductDto);
    }

    public Mono<ProductDto> createProduct(ProductDto productDto) {

        // why I use flatmap instead of map
        // when I use map it will return Mono<Mono<Object>> like so map is list to list
        // flatmap will be remove one of the first list that is why
        return Mono.just(productDto)
                .map(EntityUtil::toProduct)
                .flatMap(productDao::save)
                .map(EntityUtil::toProductDto);
    }

    public Mono<Void> deleteProduct(String id) {
        return productDao.deleteById(id);
    }

    public Mono<ProductDto> updateProduct(String id, ProductDto productDto) {
        return productDao.findById(id)
                .flatMap(p -> Mono.just(productDto))
                .map(EntityUtil::toProduct)
                .doOnNext(e -> e.setId(id))
                .flatMap(productDao::save)
                .map(EntityUtil::toProductDto);
    }
}
