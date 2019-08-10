package com.example.RestStrat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Resturants")
public class Resturant {

	@Id
	public String id;

	public String name;
	public String type;

	public Resturant(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Resturant() {
	}

}
