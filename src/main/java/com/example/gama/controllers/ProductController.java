package com.example.gama.controllers;

import java.util.List;

import com.example.gama.entities.Product;
import com.example.gama.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController{

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ModelAndView getProducts()
    {
        ModelAndView mv = new ModelAndView("products");
        mv.addObject("products", productService.getProducts());
        return mv;
    }

    @GetMapping("/products/category/{category}")
    public ModelAndView getProductsByCategory(@PathVariable(name = "category") String category)
    {
        ModelAndView mv = new ModelAndView("products");
        mv.addObject("products", productService.getProductsByCategory(category));
        return mv;
    }

    @GetMapping("/products/id/{idProduct}")
    public ModelAndView getProductById(@PathVariable(name = "idProduct") Long idProduct)
    {
        ModelAndView mv = new ModelAndView("editProduct");
        mv.addObject("products", productService.getProductsById(idProduct));
        return mv;
    }


}
