package com.teksystems.database.dao;

import com.teksystems.database.entity.Order;
import com.teksystems.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository <Order, Long> {

    @Query(value="select * from orders where id = :id ;", nativeQuery = true)
    Order findById(Integer id);

    @Query(value="select * from orders where order_status = 'Open' and user_id = :id ;", nativeQuery = true)
    Order findOpenOrder(Integer id);

}
