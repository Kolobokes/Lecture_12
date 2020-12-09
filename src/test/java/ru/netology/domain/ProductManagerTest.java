package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void productNotFound() {
        ProductManager manager = new ProductManager();
        Product[] actual = manager.searchBy("alphabet");

        Product[] expected = new Product[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void FindBook() {
        ProductManager manager = new ProductManager();
        Book alphabet = new Book(123, "alphabet", 10, "noName");
        manager.addProduct(alphabet);
        Product[] actual = manager.searchBy("alphabet");

        Product[] expected = new Product[1];
        expected[0] = alphabet;

        assertArrayEquals(expected, actual);

    }

    @Test
    void FindSmartphone() {
        ProductManager manager = new ProductManager();
        Smartphone samsung = new Smartphone(123, "samsung", 10, "noName");
        manager.addProduct(samsung);
        Product[] actual = manager.searchBy("samsung");

        Product[] expected = new Product[1];
        expected[0] = samsung;

        assertArrayEquals(expected, actual);

    }
}