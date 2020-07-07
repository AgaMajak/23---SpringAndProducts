package com.exercises.springproducts.repository;

import com.exercises.springproducts.data.Category;
import com.exercises.springproducts.data.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> productList;

    public ProductRepository() {
        productList = new ArrayList<>();

        productList.add(new Product("Spodnie damskie", 74.99, Category.ELSE));
        productList.add(new Product("Maskotka pluszowa", 29.90, Category.ELSE));
        productList.add(new Product("Czajnik elektryczny", 40.00, Category.HOUSEHOLDS_GOODS));
        productList.add(new Product("Termometr elektroniczny", 14.50, Category.HOUSEHOLDS_GOODS));
        productList.add(new Product("Jajka", 4.99, Category.FOOD));
        productList.add(new Product("Jabłka", 2.99, Category.FOOD));

    }

    public ArrayList<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public void addToProductList(Product product) {
        productList.add(product);
    }

    public List<Product> findByCategory(Category category) {
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public double sumOfPricesByCategory(Category category) {
        return productList.stream()
                .filter(product -> product.getCategory().equals(category))
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public double sumOfAllPrices() {
        return productList.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}