package com.geekbrains.spring.myMarket;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String key;

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.geekbrains.spring.myMarket.AppConfig.class);

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        do{
            System.out.println("Для вывода списка товаров введите \"all\" \n" +
                "Для добавления товара введите \"id\", далее в виде 1\n" +
                "Для отображения товара в Вашей корзине введите \"cart\" \n" +
                "Чтобы удалить из корзины, введите \"idr\", далее в виде 1\n" +
                "Если хотите выйти \"end\". "
            );
            System.out.println("Выберите действие ");
            key = in.nextLine();
            switch (key){
                case "all":
                    System.out.println(productRepository.findAll());
                    break;
                case "cart":
                    System.out.println("В Вашей корзине");
                    System.out.println(cart.findAll());
                    break;
                case "id":
                    System.out.println("Введите ID продукта: ");
                    key = in.nextLine();
                    cart.addToCart(productRepository.findById(Long.parseLong(key)));
                    break;
                case "idr":
                    System.out.println("Введите ID удаляемого из корзины продукта: ");
                    key = in.nextLine();
                    cart.removeById(Long.parseLong(key));
                    break;
                default:
                    if (!key.equals("end")){
                    System.out.println("Не удалось распознать команду, попробуйте еще раз.");
                    }

            }
        } while (!key.equals("end"));
        System.out.println("Магазин закрыт...");
        System.out.println("Продукты никогда не будут доставлены, т.к. никуда не сохранились %)");

        /*cart.addToCart(productRepository.findById(1L));
        cart.addToCart(productRepository.findById(2L));
        cart.addToCart(productRepository.findById(1L));

        System.out.println(cart.findAll());

        cart.removeById(1L);

        System.out.println(cart.findAll());*/

        context.close();
    }
}
