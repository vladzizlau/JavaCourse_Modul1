package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Product;
import java.util.ArrayList;


public interface IProduct {

     void addProd(ArrayList<Product> products);
     ArrayList<Product> getAllProduct();

void editProduct(Product product);

Product searchForCodeProduct(long code);
    Product searchForIDProduct(long id);
    void deleteProduct(Product product);
}
