package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;


import java.io.*;
import java.util.*;

public class ProductRepository implements IProduct {

    public String pathBase = "D:\\Project Java\\product.txt";
//public String pathBase = "D:\\Development Programs\\Product.txt";

    // Сохраняет товар в файл
    @Override
    public void addProd(List<Product> products)  {
            File base = new File(pathBase);
        List<Product> prod = new ArrayList<>();
            try {
                FileOutputStream FOS = new FileOutputStream(base);
                ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                    OOS.writeObject(products);
                    OOS.close();
            } catch (IOException e) {
                System.out.println("addProd: " + e.getMessage());
            }
        }


    public List<Product> getAllProduct() {
        File base = new File(pathBase);
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(base)))
        {
            products = (List<Product>) OIS.readObject();
        }
        catch (IOException | ClassNotFoundException e) { }
        return products;
    }






}


