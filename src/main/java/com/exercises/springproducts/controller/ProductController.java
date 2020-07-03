package com.exercises.springproducts.controller;

import com.exercises.springproducts.data.Product;
import com.exercises.springproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("productMap", productRepository.getProductMap());
        return "home";
    }

    @GetMapping("/lista")
    public String list(Model model, @RequestParam(name = "kategoria") String category) {
        double sumValue = productRepository.sumOfPrices(category);
        model.addAttribute("category", category);
        model.addAttribute("sum", sumValue);
        model.addAttribute("productMap", productRepository.getProductMap());
        return "products";
    }

    @PostMapping("/dodaj")
    public String add(Product product) {
        productRepository.addToAllProducts(product);
        productRepository.addToListByCategory(product.getCategory(), product);
        return "redirect:/";
    }
}