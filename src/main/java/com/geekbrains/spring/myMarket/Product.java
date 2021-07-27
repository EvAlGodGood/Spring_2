package com.geekbrains.spring.myMarket;

public class Product { //просто класс товара
    private Long id;
    private String title;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product() { //конструктор умолчание
    }

    public Product(Long id, String title, int price) { //можно заполнить при инициализации или через сеттеры
        this.id = id;
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() { //оверайдим для удобоваримого отображения продукта
        return "\n Product{" +
                "id=" + id +
                ", title='" + title +
                ", price=" + price +
                "}";
    }
}
