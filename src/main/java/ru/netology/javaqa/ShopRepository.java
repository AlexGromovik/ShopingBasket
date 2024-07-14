package ru.netology.javaqa;

import ru.netology.javaqa.exception.AlreadyExistsException;
import ru.netology.javaqa.exception.NotFoundException;

public class ShopRepository {
    private Product[] products = new Product[0];


    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        int productId = product.getId();
        if (findById(productId) != null) {
            throw new AlreadyExistsException("Product with the same ID " + productId + " already exists!!!");
        }
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void remove(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with ID " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}
