package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ProductRepository implements IProduct {

    public String pathBase = "D:\\Project Java\\product.txt";

    // Сохраняет товар в файл
    @Override
    public void addProd(List<Product> products) {
        File base = new File(pathBase);
        try {
            FileOutputStream FOS = new FileOutputStream(base, true);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            List<Product> prod = new ArrayList<>(products);
            List <Product> saveProd = new ArrayList<>();
            for (Product product : prod) {
                if (searchProduct(product.getId())== null) {
                    saveProd.add(product);
                    System.out.println("Товар сохранен: " + product);
                } else {
                    System.out.println("Такой товар уже есть: " + product);
                }
            }

            if (saveProd.size() > 0) {
                OOS.writeObject(products);
                OOS.flush();
                OOS.close();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
@Override
    public List<Product> getAllProduct() {
        File base = new File(pathBase);
        List<Product> products = new ArrayList<>();
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(base))) {
            products = (List<Product>) OIS.readObject();
        } catch (IOException | ClassNotFoundException ex) {
        }
        return products;
    }

    //Проверка товара в файле (Private)
    private boolean searchProductFile(Product prod) {
        List<Product> allProds = getAllProduct();
        Stream<Product> stream = allProds.stream();
        return stream.anyMatch(x -> x.getId() == prod.getId());
    }

    //Поиск товара по ID с возвратом объекта
    @Override
    public Product searchProduct(int id) {
        List<Product> searchProd = getAllProduct();
        Product product = null;
        for (Product u : searchProd) {
            if (u.getId() == id){
                product = searchProd.get(searchProd.indexOf(u)); }
        }
        return product;
    }

    @Override
    public void deleteProduct(Product prod) {
        if (pathBase.isEmpty()) {
            return;
        }
        List<Product> searchProd = getAllProduct();
        List<Product> newList = new ArrayList<>();
        for (Product p : searchProd) {
            if (p.getId() != prod.getId()) {
                newList.add(p);
            } else {
                System.out.println("Объект удален: " + p);
            }
        }
        try (FileOutputStream fos = new FileOutputStream(pathBase, false)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        addProd(newList);
    }
}


