package by.pvt.core.multi.service;

import by.pvt.core.multi.domain.Product;

import java.util.List;

public interface IProductService
    {


        // Добавление товара
        void addProduct(List<Product> products);

        public List<String> loadGroups();
        Product searchProduct(long code);
        Boolean searchCodeProduct(int code);

        //Редактирование товара
        void editProduct(Product products, String name, int code, String type, double price);

        void deleteProduct(Product product);
    }
