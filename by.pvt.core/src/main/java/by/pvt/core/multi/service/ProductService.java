package by.pvt.core.multi.service;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.repository.DBProductRepository;
import by.pvt.core.multi.service.Interface.IProductService;

import java.util.ArrayList;


public class ProductService implements IProductService
    {
    private final DBProductRepository productRepository;

    public ProductService()
        {

        productRepository = new DBProductRepository();
        }

    // Добавление товара
    @Override
    public void addProduct(ArrayList<Product> products)
        {
        ArrayList<Product> allprod = loadProds();
        for (Product product : products)
            {
            if (searchCodeProduct(product.getCodeProduct()) == null)
                {
                allprod.add(product);
                System.out.println("Товар сохранен: " + product);
                productRepository.addProd(allprod);
                }
            else
                {
                System.out.println("Товар с таким кодом уже есть: " + product.getId() + " " + product.getCodeProduct() + " " + product.getNameProduct());
                }
            }

        }


    //Получение всех товаров
    public ArrayList<Product> loadProds()
        {
        return productRepository.getAllProduct();
        }

    @Override
    //Поиск товара по Code с возвратом объекта
    public Product searchCodeProduct(long codeProduct)
        {
        return productRepository.searchForCodeProduct(codeProduct);
        }

    @Override
//Поиск товара по Code с возвратом объекта
    public Product searchIDProduct(long id)
        {
        return productRepository.searchForIDProduct(id);
        }

    public long getNewIndex()
        {
        return System.currentTimeMillis();
        }

    //Редактирование товара
    @Override
    public void editProduct(Product products, String name, int code, String type, double price)
        {
        products.setNameProduct(name);
        products.setCodeProduct(code);
        products.setType(type);
        products.setPrice(price);
        productRepository.editProduct(products);
        }

    @Override
    public void deleteProduct(Product product)
        {
        productRepository.deleteProduct(product);
        }


    }
