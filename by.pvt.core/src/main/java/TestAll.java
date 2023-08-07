import by.pvt.api.dto.UserRequest;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.convert.MapProduct;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.repository.ProductRepository;

import java.util.ArrayList;

public class TestAll {
    public static void main(String[] args) {
        UserRepository userRepository = ApplicationContext.getInstance().getUserRepository();
        ProductRepository productRepository = ApplicationContext.getInstance().getProductRepository();

        ArrayList<User> users = new ArrayList<>();
//        User user1 = new User(1L, "FirstUser","qwe", "werq", "375296323200", "wqe@tyty.ru", "Gomel, street Lygnikova 17\78", "123", "Admin");
//        User user2 = new User(2L, "SecondUser","zxc", "cvnm","375176987878", "sobakanasene@sobaka.ru", "BLR, Minsk", "789", "Client");
//        User user3 = new User(3L, "ThirdUSer","qer", "cbvc", "375256664422", "zxc@ya.ru", "Blr, Mogilev", "646", "Moderator");
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);

//        ArrayList<Product> prods = new ArrayList<>();
//        Product prod1 = new Product(1, "Vegetables", "Cucumber", 100, 4.99);
//        Product prod2 = new Product(2, "Vegetables", "Tomato", 130, 5.99);
//        Product prod3 = new Product(3, "Fruits", "Apple (belarus)", 246, 1.99);
//        Product prod4 = new Product(4, "Fruits", "Bananas", 589, 4.50);
//        prods.add(prod1);
//        prods.add(prod2);
//        prods.add(prod3);
//        prods.add(prod4);

        //Методы проверки UserRepository

//        userRepository.addUser(users); //Добавляет пользователей в файл
        for(var i:userRepository.getAllUsers()){ System.out.println("Загрузка пользователя из файла: " +i.getPassword());} System.out.println(userRepository.getNewIndex());
//        System.out.println("Проверка наличия пользователя в файле: " + userRepository.searchObjectUserinFile(user2));
//        System.out.println("Проверка существования пользователя с таким логином: " + userRepository.searchLoginUser("SecondUser"));
//        System.out.println("Поиск пользователя по ID: " + userRepository.searchUser(user2.getId()));
//        userRepository.deleteUser(user2); // Удаление объекта User из файла и перезапись по новой
        System.out.println(userRepository.getUser("qwe", "12345").getFullName());
        System.out.println(userRepository.getUser("qwerty", "1111").getFullName());



        //Методы проверки ProductRepository

//        productRepository.addProd(prods); //Добавляет продукт в файл
//        for(var i:productRepository.getAllProduct()){ System.out.println("Загрузка товара из файла: " +i);}
//        System.out.println("Проверка наличия продукта в файле: " + productRepository.searchProductFile(prod4));
//        System.out.println("Поиск товара по ID: " + productRepository.searchProduct(prod4.getId()));
//        productRepository.deleteProduct(prod1); // Удаление объекта Product из файла и перезапись по новой


    }
}
