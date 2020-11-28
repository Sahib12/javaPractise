package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OnlyController {
	
	ArrayList<Details> arr = new ArrayList<Details>();

	@RequestMapping(method=RequestMethod.POST, path="/details")
	public String postDetails(@RequestBody Details details) {
		arr.add(details);
		return "Data saved successfully";
	}
	
	@RequestMapping("/details")
	public ArrayList<Details> getDetails(){
		return arr;
	}
	
	@RequestMapping("/details/{id}")
	public Details getDetails(@PathVariable String id){
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getName().equals(id)) return arr.get(i);
		}
		return null;
	}
}
