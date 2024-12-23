package org.example.reactivemangodb.util;


import org.example.reactivemangodb.dto.ProductDto;
import org.example.reactivemangodb.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityUtil {

    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }
}
