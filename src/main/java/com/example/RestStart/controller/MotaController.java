package com.example.RestStart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestStart.service.MotaService;
import com.example.RestStrat.model.Customer;
import com.example.RestStrat.model.Response;
import com.example.RestStrat.model.Resturant;

@RestController
@RequestMapping("/mota")
public class MotaController {
	
	@Autowired
	MotaService service;
	
//	@RequestMapping(method=RequestMethod.GET, value="/hello")
//	public String method1() {
//		return "Hello Mota!!";
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/helloPost1/{pathvar}")
//	public String method2(@PathVariable String pathvar) {
//		return pathvar;
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/helloPost2")
//	public String method3(@RequestBody String body) {
//		return body;
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/helloPost3")
//	public String method4(@RequestParam("query") String aaa,@RequestParam("queryb") String hhh) {
//		return aaa+hhh;
//	}
//	
//	@RequestMapping(method=RequestMethod.POST, value="/helloPostMota")
//	public Mota method4(@RequestBody Mota peta) {
//		return peta;
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/save")
	public Customer methodSave(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastname) {
		return service.save(firstName, lastname);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/delete")
	public void methodDelete(@RequestParam("id") String id) {
		 service.delete(id);
	}
	@RequestMapping(method=RequestMethod.GET, value="/customer/all")
	public List<Customer> methodAll() {
		 return service.getAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/deleteall")
	public void methodDeleteAll() {
		  service.deleteAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/name")
	public Customer methodName(@RequestParam("firstName") String firstName) {
		return service.getCustomerFirstname(firstName);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/id")
	public Optional<Customer> methodId(@RequestParam("id") String id) {
		return service.getCustomerById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/resturants/all")
	public Response getResturants() {
		return service.getResturants();
	}
	
}
