package com.teksystems.database.dao;

import com.teksystems.database.entity.OrderProduct;
import com.teksystems.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {

    //get product in order
    @Query(value="select op.* from\n" +
            "products p, orders o, order_products op\n" +
            "where \n" +
            "\top.order_id = :orderId\n" +
            "\tand op.product_id = :productId\n" +
            "group by op.id;", nativeQuery = true)
    OrderProduct findOrderProductById(Integer orderId, Integer productId);

}
