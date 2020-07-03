package com.exercises.springproducts.repository;

import com.exercises.springproducts.data.Category;
import com.exercises.springproducts.data.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class ProductRepository {

    private Map<String, List<Product>> productMap;
    private List<Product> elseList;
    private List<Product> houseHoldsGoodsList;
    private List<Product> foodList;
    private List<Product> allProducts;

    public ProductRepository() {
        productMap = new TreeMap<>();
        elseList = new ArrayList<>();
        houseHoldsGoodsList = new ArrayList<>();
        foodList = new ArrayList<>();
        allProducts = new ArrayList<>();

        elseList.add(new Product("Spodnie damskie", 74.99, Category.ELSE));
        elseList.add(new Product("Maskotka pluszowa", 29.90, Category.ELSE));
        houseHoldsGoodsList.add(new Product("Czajnik elektryczny", 40.00, Category.HOUSEHOLDS_GOODS));
        houseHoldsGoodsList.add(new Product("Termometr elektroniczny", 14.50, Category.HOUSEHOLDS_GOODS));
        foodList.add(new Product("Jajka", 4.99, Category.FOOD));
        foodList.add(new Product("Jabłka", 2.99, Category.FOOD));

        allProducts.addAll(elseList);
        allProducts.addAll(houseHoldsGoodsList);
        allProducts.addAll(foodList);

        productMap.put("Artykuły gospodarstwa domowego", houseHoldsGoodsList);
        productMap.put("Artykuły spożywcze", foodList);
        productMap.put("Inne", elseList);
        productMap.put("Wszystkie produkty", allProducts);
    }

    public Map<String, List<Product>> getProductMap() {
        return productMap;
    }

    private void addToElseList(Product product) {
        elseList.add(product);
    }

    private void addToHouseHoldsGoodsList(Product product) {
        houseHoldsGoodsList.add(product);
    }

    private void addToFoodList(Product product) {
        foodList.add(product);
    }

    public void addToAllProducts(Product product) {
        allProducts.add(product);
    }

    public void addToListByCategory(Category category, Product product) {
        switch (category) {
            case ELSE: {
                addToElseList(product);
                break;
            }
            case FOOD: {
                addToFoodList(product);
                break;
            }
            case HOUSEHOLDS_GOODS: {
                addToHouseHoldsGoodsList(product);
                break;
            }
        }
    }

    public double sumOfPrices(String mapKey) {
        double sum = 0;
        for (Product product : productMap.get(mapKey)) {
            sum += product.getPrice();
        }
        return sum;
    }
}