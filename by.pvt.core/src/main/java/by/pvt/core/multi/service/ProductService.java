package by.pvt.core.multi.service;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService implements IProductService
    {
    ProductRepository productRepository;

    public ProductService(){
    productRepository = new ProductRepository();
    }

    // Добавление товара
        @Override
        public void addProduct(List<Product> products) {
            List<Product> allprod = loadProds();
                for (Product product : products) {
                    if (!searchCodeProduct(product.getCodeProduct())) {
                        allprod.add(product);
                        System.out.println("Товар сохранен: " + product);
                    } else {
                        System.out.println("Товар с таким кодом уже есть: " + product.getId() + " " + product.getCodeProduct() + " " + product.getNameProduct());
                    }
                }

                    productRepository.addProd(allprod);



        }

    public List<String> loadGroups(){ //получает группы товаров для создания категорий
    List<String> groups = new ArrayList<>();
    for (Product io: productRepository.getAllProduct()){
    if(!groups.contains(io.getType()))
        groups.add(io.getType());
    }
    return groups;
    }
    //Получение всех товаров
    public List<Product> loadProds(){
        return productRepository.getAllProduct();
    }
@Override
        //Поиск товара по ID с возвратом объекта
        public Product searchProduct(long id) {
            List<Product> searchProd = loadProds();
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
            List<Product> searchProd = productRepository.getAllProduct();
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
            List<Product> allProduct = loadProds();
            int index = 0;
            for (int i = 0; i < allProduct.size(); i++) {
                if (allProduct.get(i).getId() == products.getId()) {
                    index = i;
                }
            }
            allProduct.set(index, products);
            productRepository.addProd(allProduct);

        }

@Override
        public void deleteProduct(Product product) {
        List<Product> allProduct = loadProds();
        allProduct.removeIf(s-> s.getId() == product.getId());
        productRepository.addProd(allProduct);
}

    }
