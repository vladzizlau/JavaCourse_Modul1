package by.pvt.core.multi.config;

import by.pvt.api.dto.*;
import by.pvt.core.multi.controller.*;
import by.pvt.core.multi.convert.*;
import by.pvt.core.multi.repository.*;
import by.pvt.core.multi.service.*;


public class ApplicationContext {

    private static final ApplicationContext applicationContext = new ApplicationContext();
    private final Controller controller;
    private final CartController cartController;
    private final UserController userController;
    private final AdminController adminController;
    private final ProductConverter productConverter;
    private final UserConverter userConverter;
    private final DBProductRepository productRepository;
    private final DBUserRepository userRepository;
    private final DBOrderRepository orderRepository;
    private final DBShopRepository shopRepository;
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
//    private final DBOrderRepository dbOrderRepository;
//    private final DBProductRepository dbProductRepository;
//    private final DBShopRepository dbShopRepository;
//    private final DBUserRepository dbUserRepository;

    private ApplicationContext() {
        controller = new Controller();
        cartController = new CartController();
        userController = new UserController();
        adminController = new AdminController();
        productConverter = new ProductConverter();
        userConverter = new UserConverter();
        productRepository = new DBProductRepository();
        userRepository = new DBUserRepository();
        orderRepository = new DBOrderRepository();
        shopRepository = new DBShopRepository();
        userService = new UserService();
        productService = new ProductService();
        productRequest = new ProductRequest();
        productResponse = new ProductResponse();
        shopService = new ShopService();
        cartService = new CartService();
        orderService = new OrderService();
        userRequest = new UserRequest();
        userResponse = new UserResponse();
        shopCartRequest = new ShopCartRequest();
        shopCartResponse = new ShopCartResponse();
//        dbOrderRepository = new DBOrderRepository();
//        dbProductRepository = new DBProductRepository();
//        dbShopRepository = new DBShopRepository();
//        dbUserRepository = new DBUserRepository();
    }

    public Controller getController() {
        return controller;
    }

    public CartController getCartController() {
        return cartController;
    }

    public UserController getUserController() {
        return userController;
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public ProductConverter getProductConverter() {
        return productConverter;
    }

    public UserConverter getUserConverter() {
        return userConverter;
    }

    public ProductRequest getProductRequest() {
        return productRequest;
    }

    public ProductResponse getProductResponse() {
        return productResponse;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public ShopCartRequest getShopCartRequest() {
        return shopCartRequest;
    }

    public ShopCartResponse getShopCartResponse() {
        return shopCartResponse;
    }

    public DBUserRepository getUserRepository() {
        return userRepository;
    }

    public DBProductRepository getProductRepository() {
        return productRepository;
    }

    public DBOrderRepository getOrderRepository() {
        return orderRepository;
    }

    public DBShopRepository getShopRepository() {
        return shopRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public ShopService getShopService() {
        return shopService;
    }

    public CartService getCartService() {
        return cartService;
    }

    public OrderService getOrderService() {
        return orderService;
    }


    public static synchronized ApplicationContext getInstance() {
        return applicationContext;
    }
}
