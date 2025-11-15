package com.chubb.demo.controller;

import com.chubb.demo.DTO.Orders;
import com.chubb.demo.service.OrderService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {
	
	@Autowired
	OrderService service;


	@GetMapping("/order")
	String getOrder() {
		return "Hello";
	}
	
	@PostMapping("/save")
    Orders putOrder(@Valid @RequestBody Orders orders) {
		log.debug("request received");
		service.saveOrder(orders);
		return orders;
	}
}
