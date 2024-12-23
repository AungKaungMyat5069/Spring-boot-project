package org.example.onetomany.service;

import lombok.RequiredArgsConstructor;
import org.example.onetomany.dao.CategoryDao;
import org.example.onetomany.dao.ProductDao;
import org.example.onetomany.entity.Category;
import org.example.onetomany.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryDao categoryDao;
    private final ProductDao productDao;

    @Transactional
    public void createdb() {
        Category category1 = new Category();
        Category category2 = new Category();

        category1.setName("Fruit");
        category2.setName("Meat");


        Product product1 = new Product("Apple", 3.8, 10);
        Product product2 = new Product("Beef", 25.8, 28);
        Product product3 = new Product("Grapes", 1.5, 20);
        Product product4 = new Product("Chicken", 10.5, 20);

        category1.addProduct(product1);
        category1.addProduct(product3);
        category2.addProduct(product2);
        category2.addProduct(product4);

        categoryDao.save(category1);
        categoryDao.save(category2);
        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);
        productDao.save(product4);

    }
}
