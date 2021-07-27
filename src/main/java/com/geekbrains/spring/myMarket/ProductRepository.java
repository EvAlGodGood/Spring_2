package com.geekbrains.spring.myMarket;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private static List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Milk", 85),
                new Product(2L, "Coffee", 125),
                new Product(3L, "Salt", 22),
                new Product(4L, "Bread", 30),
                new Product(5L, "Balsamic vinegar", 230)
        ));
    }

    // возвращаем весь список
    public List<Product> findAll() {
        return products;
    }

    // находим в списке первый совпавший ID и выбрасываем объект
    public Product findById(Long id) {
        return products.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }

}
