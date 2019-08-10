package com.example.RestStart.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestStart.repository.MotaRepository;
import com.example.RestStart.repository.ResturantRepository;
import com.example.RestStrat.model.Customer;
import com.example.RestStrat.model.Response;
import com.example.RestStrat.model.Resturant;

@Service
public class MotaService {

	@Autowired
	MotaRepository repository;
	
	@Autowired
	ResturantRepository restRepository;
	
	@PostConstruct
	public void save() {
		deleteAll();
		restRepository.save(new Resturant("Shah Ghouse", "Non-Veg"));
		restRepository.save(new Resturant("Dine-O-China", "Non-Veg"));
		restRepository.save(new Resturant("Raddisson", "Veg"));
		restRepository.save(new Resturant("Punjabi Bytes", "Non-Veg"));
	}

	public Optional<Customer> getCustomerById(String id) {
		return repository.findById(id);
	}

	public Customer getCustomerFirstname(String firstName) {
		return repository.findByFirstName(firstName);
	}

	public Customer save(String firstName, String lastname) {
		return repository.save(new Customer(firstName,lastname));
	}

	public void delete(String id) {
		repository.deleteById(id);
	}

	public List<Customer> getAll() {
		return repository.findAll();
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Response getResturants() {
		Response r = new Response();
		r.setData(restRepository.findAll());
		return r;
	}

}
