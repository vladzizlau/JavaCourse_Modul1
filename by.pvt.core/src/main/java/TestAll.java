import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.service.ProductService;
import by.pvt.core.multi.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestAll {
    public static void main(String[] args) throws IOException {
        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();
        ProductRepository productRepository = ApplicationContext.getInstance().getProductRepository();

        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(System.currentTimeMillis(), "FirstUser","qwe", "werq",  37529632, "wqe@tyty.ru",  "123", "Admin");
        User user2 = new User(System.currentTimeMillis(), "SecondUser","zxc", "cvnm",324536563, "sobakanasene@sobaka.ru", "789", "Client");
        User user3 = new User(System.currentTimeMillis(), "ThirdUSer","qer", "cbvc", 656565635, "zxc@ya.ru", "646", "Moderator");
        users.add(user1);
        users.add(user2);
        users.add(user3);

//        List<Product> prods = new ArrayList<>();
//        Product prod1 = new Product(System.currentTimeMillis(),"Vegetables", "Cucumber", 100, 4.99);
//        Product prod2 = new Product(System.currentTimeMillis(),"Vegetables", "Tomato", 130, 5.99);
//        Product prod3 = new Product(System.currentTimeMillis(), "Fruits", "Apple (belarus)", 246, 1.99);
//        Product prod4 = new Product(System.currentTimeMillis(), "Fruits", "Bananas", 589, 4.50);
//
//            prods.add(prod1);
//            prods.add(prod2);
//            prods.add(prod3);
//            prods.add(prod4);



        //Методы проверки UserRepository

 //      userRepository.addUser(users); //Добавляет пользователей в файл
//      for(var i:userRepository.getAllUsers()){System.out.println("Загрузка пользователя из файла:" + i.getLogin());}
//        System.out.println("Проверка наличия пользователя в файле: " + userRepository.searchObjectUserinFile(user2));
//        System.out.println("Проверка существования пользователя с таким логином: " + userRepository.searchLoginUser("SecondUser"));
//        System.out.println("Поиск пользователя по ID: " + userRepository.searchUser(user2.getId()));
//        userRepository.deleteUser(user2); // Удаление объекта User из файла и перезапись по новой
//        System.out.println(userRepository.getUser("qwe", "12345").getFullName());
//        System.out.println(userRepository.getUser("qwerty", "1111").getFullName());

        UserService userService = new UserService();
        ProductService productService = new ProductService();
//        Методы проверки ProductRepository

//  productService.addProduct(prods); //Добавляет продукт в файл
 //      for(var i:productRepository.getAllProduct()){ System.out.println("Загрузка товара из файла: " +i.getId() + " " +i.getNameProduct());}

//        System.out.println("Проверка наличия продукта в файле: " + productRepository.searchProductFile(prod4));
//        System.out.println("Поиск товара по ID: " + productRepository.searchProduct(prod4.getId()));
//        productRepository.deleteProduct(prod1); // Удаление объекта Product из файла и перезапись по новой
//        System.out.println(productRepository.getNewIndex());

//    System.out.println(userRepository.getUser("qwerty"));
    //userService.auth("qwerty", "123451");



      List<Product> q = productService.loadProds();
       // System.out.println(q.indexOf(q.get(3)));
//     productService.editProduct(q.get(1), "TestProd", 123, "Velo", 3.23);
//        productService.deleteProduct(q.get(0));
//        q.add("Vegetables");


    }

}
