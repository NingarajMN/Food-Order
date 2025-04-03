package com.NMN.foodorder.repositories;

import com.NMN.foodorder.entities.Orders;
import com.NMN.foodorder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
        List<Orders> findOrdersByUser(User user);

}
