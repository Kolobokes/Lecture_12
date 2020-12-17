package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;
import ru.netology.domain.NotFoundException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {

        return items;
    }

    public boolean findByID(int ID) {
        for (Product product: findAll()) {
            int productID = product.getId();
            if (productID == ID) {
                return true;
            }
        }
        return false;
    }

    public void removeById(int id) {

        if (findByID(id) == false){
            new NotFoundException("id not found");
        }

        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}