package by.maven.firstmodule;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    UserRepository uR = new UserRepository();
    ArrayList<User> setStream = new ArrayList<>();
    User user1 = new User(1L, "FirstUser","qwe", "werq", "123", "Admin");
    User user2 = new User(2L, "SecondUser","zxc", "cvnm", "789", "Client");
    User user3 = new User(3L, "ThirdUSer","qer", "cbvc", "vcbv", "Moderator");
        User user4 = new User(2L, "SecondUser","zxc", "cvnm", "789", "Client");
    setStream.add(user1);
    setStream.add(user2);
    setStream.add(user3);


    //Методы проверки

//        uR.addUser(setStream); //Добавляет пользователей в файл
//        for(var i:uR.getAllUsers()){ System.out.println("Загрузка пользователя из файла: " +i);}
//        System.out.println("Проверка наличия пользователя в файле: " + uR.searchObjectUserinFile(user2));
//        System.out.println("Проверка существования пользователя с таким логином: " + uR.searchLoginUser("SecondUser"));
//        System.out.println("Поиск пользователя по ID: " + uR.searchUser(user2.getId()));
//        uR.deleteUser(user2); // Удаление объекта User из файла и перезапись по новой


    }
}
