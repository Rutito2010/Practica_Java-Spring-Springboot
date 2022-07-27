package com.example.PracticaSpringBoot.Service;

import com.example.PracticaSpringBoot.Entities.Books;

public class BooksPriceCalculator {

    public double calculaterPrice(Books book) {
        double price = book.getPrice();
        if (book.getPages() > 300) {

            price += 5;


        }
        price += 2;
        return price;
    }
}
