package com.example.LabCycle4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	List<Product> list = new ArrayList<Product>();
	
	@GetMapping
	public List<Product> getProduct() {
		return list;
	}
	
	@PostMapping
	public List<Product> insertProduct(@RequestBody Product product) {
		list.add(product);
		return list;
	}
	
	@DeleteMapping("/{id}")
	public List<Product> deleteProduct(@PathVariable int id) {
		for(Product p: list) {
			if(id == p.getId()) {
				list.remove(p);
			}
		}
		return list;
	}
	
	@PutMapping
	public List<Product> updateProduct(@RequestBody Product product) {
		for(Product p: list) {
			if(product.getId() == p.getId()) {
				p.setName(product.getName());
				p.setPrice(product.getPrice());
				break;
			}
		}
		return list;
	}
}