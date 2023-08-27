package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.repository.Interface.IProduct;


import java.io.*;
import java.util.*;

public class ProductRepository implements IProduct {

    public String pathBase = "D:\\Project Java\\product.txt";
//public String pathBase = "D:\\Development Programs\\JavaProject\\Product.txt";

    // Сохраняет товар в файл
    @Override
    public void addProd(ArrayList<Product> products)  {
            File base = new File(pathBase);
            try {
                FileOutputStream FOS = new FileOutputStream(base);
                ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                    OOS.writeObject(products);
                    OOS.close();
                    FOS.close();
            } catch (IOException e) {
                System.out.println("addProd: " + e.getMessage());
            }
        }


    public ArrayList<Product> getAllProduct() {
        File base = new File(pathBase);
        ArrayList<Product> products = new ArrayList<>();
        try
        {
            FileInputStream fileInputStream = new FileInputStream(pathBase);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (ArrayList<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }

        catch (IOException | ClassNotFoundException e) { }
        return products;
    }






}


