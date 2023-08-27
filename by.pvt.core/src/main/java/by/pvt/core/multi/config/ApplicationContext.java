package by.pvt.core.multi.config;

import by.pvt.api.dto.*;
import by.pvt.core.multi.controller.Controller;
import by.pvt.core.multi.controller.shop.CartController;
import by.pvt.core.multi.controller.user.UserController;
import by.pvt.core.multi.controller.admin.AdminController;
import by.pvt.core.multi.convert.ProductConverter;
import by.pvt.core.multi.convert.UserConverter;
import by.pvt.core.multi.repository.OrderRepository;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.repository.ShopRepository;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.service.*;


public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final Controller controller;
    private final CartController cartController;
    private final UserController userController;
    private final AdminController adminController;
    private final ProductConverter productConverter;
    private final UserConverter userConverter;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ShopRepository shopRepository;
    private final ProductRequest productRequest;
    private final ProductResponse productResponse;
    private final UserRequest userRequest;
    private final UserResponse userResponse;
    private final ShopCartRequest shopCartRequest;
    private final ShopCartResponse shopCartResponse;
    private final UserService userService;
    private final ProductService productService;
    private final ShopService shopService;
    private final CartService cartService;
    private final OrderService orderService;

    public ApplicationContext() {
        controller = new Controller();
        cartController = new CartController();
        userController = new UserController();
        adminController = new AdminController();
        productConverter = new ProductConverter();
        userConverter = new UserConverter();
        productRequest = new ProductRequest();
        productResponse = new ProductResponse();
        userRequest = new UserRequest();
        userResponse = new UserResponse();
        shopCartRequest = new ShopCartRequest();
        shopCartResponse = new ShopCartResponse();
        productRepository = new ProductRepository();
        userRepository = new UserRepository();
        orderRepository = new OrderRepository();
        shopRepository = new ShopRepository();
        userService = new UserService();
        productService = new ProductService();
        shopService = new ShopService();
        cartService = new CartService();
        orderService = new OrderService();
    }
    public Controller getController(){return controller;}
    public CartController getCartController(){return cartController;}
    public UserController getUserController(){return userController;}
    public AdminController getAdminController(){return adminController;}
    public ProductConverter getProductConverter() {return productConverter;}
    public UserConverter getUserConverter() {return userConverter;}
    public ProductRequest getProductRequest() {return productRequest;}
    public ProductResponse getProductResponse(){return productResponse;}
    public UserRequest getUserRequest() {return userRequest;}
    public UserResponse getUserResponse() {return userResponse;}
    public ShopCartRequest getShopCartRequest(){return shopCartRequest;}
    public ShopCartResponse getShopCartResponse(){return shopCartResponse;}
    public UserRepository getUserRepository(){return userRepository;}
    public ProductRepository getProductRepository() {return productRepository;}
    public OrderRepository getOrderRepository() {return orderRepository;}
    public ShopRepository getShopRepository() {return shopRepository;}
    public UserService getUserService(){return userService;}
    public ProductService getProductService(){return productService;}
    public ShopService getShopService(){return shopService;}
    public CartService getCartService(){return cartService;}
    public  OrderService getOrderService(){return orderService;}





    public static ApplicationContext getInstance()
    {
        if (applicationContext == null)
        {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }
}
