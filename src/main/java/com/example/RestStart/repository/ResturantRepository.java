package com.example.RestStart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.RestStrat.model.Resturant;

public interface ResturantRepository extends MongoRepository<Resturant, String>{

	public List<Resturant> findByName(String name);
}
