package com.example.PracticaSpringBoot.Service;

import com.example.PracticaSpringBoot.Entities.Books;
import org.junit.jupiter.api.Test;

import java.awt.print.Book;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BooksPriceCalculatorTest {

    @Test
    void calculaterPrice() {
Books book=new Books(null,"Metro","Author", 400, 19.99, "Historia de Artyon en la rusia post Apocaliptica", LocalDate.of(1990,12,23));
        BooksPriceCalculator calculator = new BooksPriceCalculator();
      double price=  calculator.calculaterPrice(book);
        assertTrue(price > 0);
        assertTrue(price==26.99);
    }
}