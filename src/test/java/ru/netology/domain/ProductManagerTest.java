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
    void FindSomeBook() {
        ProductManager manager = new ProductManager();
        Book alphabet = new Book(123, "alphabet", 10, "noName");
        Book fairyTales = new Book(124, "fairyTales", 20, "noName");
        manager.addProduct(alphabet);
        manager.addProduct(fairyTales);
        Product[] actual = manager.searchBy("noName");

        Product[] expected = new Product[2];
        expected[0] = alphabet;
        expected[1] = fairyTales;

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

    @Test
    void FindSomeSmartphone() {
        ProductManager manager = new ProductManager();
        Smartphone samsung = new Smartphone(123, "samsung", 10, "noName");
        Smartphone lg = new Smartphone(124, "lg", 100, "noName");
        manager.addProduct(samsung);
        manager.addProduct(lg);
        Product[] actual = manager.searchBy("noName");

        Product[] expected = new Product[2];
        expected[0] = samsung;
        expected[1] = lg;

        assertArrayEquals(expected, actual);

    }
}