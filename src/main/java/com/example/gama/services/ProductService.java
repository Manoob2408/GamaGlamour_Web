package com.example.gama.services;

import java.util.List;

import javax.transaction.Transactional;

import com.example.gama.entities.Product;
import com.example.gama.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts()
    {
        return repository.findAll();
    }

    public void saveProduct(Product product)
    {
        repository.save(product);
    }

    @Transactional
	public List<Product> getProductsByCategory(String category) {
		
		return repository.findProductByCategory(category);
	}

}
