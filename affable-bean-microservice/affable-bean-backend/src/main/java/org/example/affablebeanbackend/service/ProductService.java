package org.example.affablebeanbackend.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.affablebeanbackend.dao.CustomerDao;
import org.example.affablebeanbackend.dao.CustomerOrderProductDao;
import org.example.affablebeanbackend.dao.OrderProductDao;
import org.example.affablebeanbackend.dao.ProductDao;
import org.example.affablebeanbackend.dto.CartItemDto;
import org.example.affablebeanbackend.dto.OrderDetailDto;
import org.example.affablebeanbackend.dto.ProductDto;
import org.example.affablebeanbackend.entity.Customer;
import org.example.affablebeanbackend.entity.CustomerOrderProduct;
import org.example.affablebeanbackend.entity.OrderProduct;
import org.example.affablebeanbackend.util.EntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;
    private final CustomerDao customerDao;
    private final OrderProductDao orderProductDao;
    private final CustomerOrderProductDao customerOrderProductDao;



    public ProductService(ProductDao productDao, CustomerDao customerDao, OrderProductDao orderProductDao, CustomerOrderProductDao customerOrderProductDao) {
        this.productDao = productDao;
        this.customerDao = customerDao;
        this.orderProductDao = orderProductDao;
        this.customerOrderProductDao = customerOrderProductDao;
    }


    public List<ProductDto> getAllProducts() {
        return productDao.findAll().stream()
                .map(EntityUtil::toProductDto)
                .toList();
    }

    public List<ProductDto> getProductsByCategoryId(Integer categoryId) {
        return productDao.findByCategoryId(categoryId)
                .stream().map(EntityUtil::toProductDto)
                .toList();
    }

    @Transactional
    public void saveOrderProducts(OrderDetailDto orderDetailDto) {
        Customer customer = new Customer(
                orderDetailDto.getName(),
                orderDetailDto.getAddress(),
                orderDetailDto.getEmail(),
                orderDetailDto.getPhoneNumber()
        );


        customerDao.save(customer);


        for (CartItemDto p : orderDetailDto.getProducts()) {
            OrderProduct orderProduct = new OrderProduct(p.getName(), p.getPrice(), p.getQuantity());
            CustomerOrderProduct customerOrderProduct = new CustomerOrderProduct();
            customerOrderProduct.setOrderNumber(orderDetailDto.getOrderNumber());
            customer.addOrderProduct(customerOrderProduct);// link customer
            customerOrderProductDao.save(customerOrderProduct);

            // Your method — creates a row in the join table
            orderProduct.addCustomerOrderProduct(customerOrderProduct);

            orderProductDao.save(orderProduct); // you need to save each one
        }
    }

}
