package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Product;
import java.util.ArrayList;


public interface IProduct {

     // Сохраняет товар в файл
     void addProd(ArrayList<Product> products);

     ArrayList<Product> getAllProduct();


}
