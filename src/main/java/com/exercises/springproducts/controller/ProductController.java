package com.exercises.springproducts.controller;

import com.exercises.springproducts.data.Category;
import com.exercises.springproducts.data.Product;
import com.exercises.springproducts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("products", productRepository.findAll());
        return "home";
    }

    @GetMapping("/lista")
    public String list(Model model, @RequestParam(name = "kategoria", required = false) Category category) {
        model.addAttribute("category", category);
        Optional<Category> categoryOptional = Optional.ofNullable(category);

        if (categoryOptional.isEmpty()) {
            model.addAttribute("products", productRepository.findAll());
            model.addAttribute("sum", productRepository.sumOfAllPrices());
        } else {
            model.addAttribute("products", productRepository.findByCategory(category));
            model.addAttribute("sum", productRepository.sumOfPricesByCategory(category));
        }
        return "products";
    }

    @PostMapping("/dodaj")
    public String add(Product product) {
        productRepository.addToProductList(product);
        return "redirect:/";
    }
}