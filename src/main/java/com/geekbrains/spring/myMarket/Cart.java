package com.geekbrains.spring.myMarket;

import com.geekbrains.spring.demo5.Item;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Cart {
    private static List<Product> productCart;

    @PostConstruct
    public void init() {
        productCart = new ArrayList<>(Arrays.asList());
    }

    public void addToCart(Product product) {
        productCart.add(product);
    }

    public List<Product> findAll() {
        return productCart;
    }

    public void removeById(Long id) {
        productCart.remove(productCart.stream().filter(i -> i.getId().equals(id)).findFirst().get());
        //нужно разобраться с лямбдами..
    }

}
