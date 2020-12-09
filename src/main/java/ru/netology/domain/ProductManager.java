package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {

    ProductRepository repository = new ProductRepository();

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                tmp[tmp.length - 1] = product;
                result = tmp;
          //      System.arraycopy(tmp, 0, result, 0, tmp.length);
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
            return false;
        }

        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
