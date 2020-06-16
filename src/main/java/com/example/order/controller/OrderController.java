package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.order.entity.User;


@RestController
public class OrderController {
	
	@Autowired
	RestTemplate template;

	@GetMapping(value = "/orders/{userid}")
	public ResponseEntity<User> getUser(@PathVariable("userid") Long userid) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
	HttpEntity entity = new HttpEntity<>(null,headers);
	String url = "http://localhost:8080/userorders/"+userid;
	ResponseEntity<User> user = template.exchange(url,HttpMethod.GET,entity ,User.class);

         return user;
	}

}
