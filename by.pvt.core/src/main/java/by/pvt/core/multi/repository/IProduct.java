package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;

import java.io.IOException;
import java.util.List;

public interface IProduct {

     // Сохраняет товар в файл
     void addProd(List<Product> products);

     List<Product> getAllProduct();


}
