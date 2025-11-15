package com.chubb.demo.service;

import com.chubb.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chubb.demo.DTO.Orders;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

	public void saveOrder(Orders orders) {
		orders.setPrice(orders.getPrice()* orders.getQuantity());
        orderRepository.save(orders);
		log.debug("order saved");
	}
	
}
