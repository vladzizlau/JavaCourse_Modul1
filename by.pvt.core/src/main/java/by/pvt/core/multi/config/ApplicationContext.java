package by.pvt.core.multi.config;

import by.pvt.api.dto.ProductRequest;
import by.pvt.api.dto.ProductResponse;
import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.controller.Controller;
import by.pvt.core.multi.convert.MapProduct;
import by.pvt.core.multi.convert.MapUser;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.repository.UserRepository;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final Controller controller;
    private final MapProduct mapProduct;
    private final MapUser mapUser;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductRequest productRequest;
    private final ProductResponse productResponse;
    private final UserRequest userRequest;
    private final UserResponse userResponse;


    public ApplicationContext() {
        controller = new Controller();
        mapProduct = new MapProduct();
        mapUser = new MapUser();
        productRequest = new ProductRequest();
        productResponse = new ProductResponse();
        userRequest = new UserRequest();
        userResponse = new UserResponse();
        productRepository = new ProductRepository();
        userRepository = new UserRepository();

    }

    public static ApplicationContext getInstance()
    {
        if (applicationContext == null)
        {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }
public Controller getController(){return controller;}
    public MapProduct getMapProduct() {return mapProduct;}
    public MapUser getMapUser() {return mapUser;}
    public ProductRequest getProductRequest() {return productRequest;}
    public ProductResponse getProductResponse(){return productResponse;}
    public UserRequest getUserRequest() {return userRequest;}
    public UserResponse getUserResponse() {return userResponse;}
    public UserRepository getUserRepository(){return userRepository;}
    public ProductRepository getProductRepository() {return productRepository;}
}
