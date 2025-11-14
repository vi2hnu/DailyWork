package com.chubb.demo.service;

import org.springframework.stereotype.Service;
import com.chubb.demo.DTO.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderService {
	
	
	public void saveOrder(Order order) {
		order.setPrice(order.getPrice()*order.getQuantity());
		log.debug("order saved");
	}
}
