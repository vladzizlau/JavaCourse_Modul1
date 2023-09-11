package by.pvt.core.multi.repository;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.repository.Interface.IProduct;


import java.io.*;
import java.util.*;

public class ProductRepository implements IProduct {

    private final String PATH = "D:\\Project Java\\product.txt";
//    private final String PATH = "D:\\Development Programs\\JavaProject\\Product.txt"; //Work


    // Сохраняет товар в файл
    @Override
    public void addProd(ArrayList<Product> products)  {
            File base = new File(PATH);
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

    @Override
    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> products = new ArrayList<>();
        try
        {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (ArrayList<Product>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }

        catch (IOException | ClassNotFoundException e) { }
        return products;
    }

    @Override
    //Поиск товара по Code с возвратом объекта
    public Product searchForCodeProduct(long id) {
        ArrayList<Product> searchProd = getAllProduct();
        Product product = null;
        for (Product u : searchProd) {
            if (u.getId() == id){
                product = searchProd.get(searchProd.indexOf(u)); }
            else { System.out.println("Продукт не найден");}
        }

        return product;
    }

@Override
public Product searchForIDProduct(long id)
    {
    ArrayList<Product> searchProd = getAllProduct();
    Product product = null;
    for (Product u : searchProd) {
    if (u.getId() == id){
    product = searchProd.get(searchProd.indexOf(u)); }
    else { System.out.println("Продукт не найден");}
    }

    return product;
    }

@Override
public void editProduct(Product product)
    {
    ArrayList<Product> allProduct = getAllProduct();
    int index = 0;
    for (int i = 0; i < allProduct.size(); i++) {
    if (allProduct.get(i).getId() == product.getId()) {
    index = i;
    }
    }
    allProduct.set(index, product);
    addProd(allProduct);
    }

@Override
    public void deleteProduct(Product product) {
        ArrayList<Product> allProduct = getAllProduct();
        allProduct.removeIf(s-> s.getId() == product.getId());
        ApplicationContext.getInstance().getProductRepository().addProd(allProduct);
    }





}


