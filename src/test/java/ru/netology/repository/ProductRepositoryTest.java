package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void removeByNotFoundId() {
        ProductRepository repository = new ProductRepository();
        Book alphabet = new Book(123, "alphabet", 10, "noName");
        repository.save(alphabet);

        assertThrows(RuntimeException.class, () -> repository.removeById(124));
    }

    @Test
    void removeById() {
        ProductRepository repository = new ProductRepository();
        Book alphabet = new Book(123, "alphabet", 10, "noName");
        repository.save(alphabet);

        repository.removeById(123);

        boolean actual = repository.findByID(123);

        assertEquals(false, actual);
    }
}