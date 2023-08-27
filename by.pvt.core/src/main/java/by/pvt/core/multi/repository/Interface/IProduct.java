package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IProduct {

     // Сохраняет товар в файл
     void addProd(ArrayList<Product> products);

     ArrayList<Product> getAllProduct();


}
