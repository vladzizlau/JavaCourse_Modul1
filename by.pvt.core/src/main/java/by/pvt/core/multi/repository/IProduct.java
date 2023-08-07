package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;

import java.io.IOException;
import java.util.List;

public interface IProduct {
    abstract void addProd(List<Product> products) throws IOException;
    abstract List<Product> getAllProduct();
    abstract Product searchProduct(int id);
    abstract void deleteProduct(Product prod) throws IOException;
}
