package by.pvt.core.multi.service.Interface;

import by.pvt.core.multi.domain.Product;

import java.util.ArrayList;


public interface IProductService
    {
        void addProduct(ArrayList<Product> products);
        Product searchCodeProduct(long code);

    //Поиск товара по Code с возвратом объекта
    Product searchIDProduct(long id);

    void editProduct(Product products, String name, int code, String type, double price);
        void deleteProduct(Product product);
    }
