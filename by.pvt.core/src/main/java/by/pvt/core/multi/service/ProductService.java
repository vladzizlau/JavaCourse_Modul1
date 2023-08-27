package by.pvt.core.multi.service;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.service.Interface.IProductService;

import java.util.ArrayList;


public class ProductService implements IProductService
    {
    // Добавление товара
        @Override
        public void addProduct(ArrayList<Product> products) {
            ArrayList<Product> allprod = loadProds();
                for (Product product : products) {
                    if (!searchCodeProduct(product.getCodeProduct())) {
                        allprod.add(product);
                        System.out.println("Товар сохранен: " + product);
                    } else {
                        System.out.println("Товар с таким кодом уже есть: " + product.getId() + " " + product.getCodeProduct() + " " + product.getNameProduct());
                    }
                }
                    ApplicationContext.getInstance().getProductRepository().addProd(allprod);
        }



    //Получение всех товаров
    public ArrayList<Product> loadProds(){
        return ApplicationContext.getInstance().getProductRepository().getAllProduct();
    }
@Override
        //Поиск товара по ID с возвратом объекта
        public Product searchProduct(long id) {
            ArrayList<Product> searchProd = loadProds();
            Product product = null;
            for (Product u : searchProd) {
                if (u.getId() == id){
                    product = searchProd.get(searchProd.indexOf(u)); }
                else { System.out.println("Продукт не найден");}
            }

            return product;
        }
        public long getNewIndex(){
            return System.currentTimeMillis();
        }
        //Проверка на наличие товара по коду.  true/false
        @Override
        public Boolean searchCodeProduct(int code) {
            ArrayList<Product> searchProd = loadProds();
            for (Product u : searchProd) {
                if (u.getCodeProduct() == code){
                    return true; }
            }
            return false;
        }
//Редактирование товара
@Override
        public void editProduct(Product products, String name, int code, String type, double price){
        products.setNameProduct(name);
        products.setCodeProduct(code);
        products.setType(type);
        products.setPrice(price);
            ArrayList<Product> allProduct = loadProds();
            int index = 0;
            for (int i = 0; i < allProduct.size(); i++) {
                if (allProduct.get(i).getId() == products.getId()) {
                    index = i;
                }
            }
            allProduct.set(index, products);
            ApplicationContext.getInstance().getProductRepository().addProd(allProduct);

        }

@Override
        public void deleteProduct(Product product) {
        ArrayList<Product> allProduct = loadProds();
        allProduct.removeIf(s-> s.getId() == product.getId());
        ApplicationContext.getInstance().getProductRepository().addProd(allProduct);
}

    }
