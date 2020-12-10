package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {

    ProductRepository repository = new ProductRepository();

    public Product[] searchBy(String text) {
        Product[] result = new Product[repository.findAll().length];
        int counter = -1;
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                counter = counter + 1;
                Product[] tmp = new Product[1];
                tmp[0] = product;
        //        result = tmp;
                System.arraycopy(tmp, 0, result, counter, tmp.length);
            }
        }
        return result;
    }

    public void addProduct(Product product){
        repository.save(product);
    }

    public boolean matches(Product product, String search) {

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (smartphone.getProducer().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
