package by.maven.firstmodule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserRepository implements IUsers {

    public String pathBase = "D:\\Project Java\\FirstModule\\src\\main\\resources\\base.txt";

    //public String pathBase = "D:\\Development Programs\\JavaProject\\base.txt";

    // Добавляет и сохраняет пользователей в файл
    @Override
    public void addUser(List<User> user) {
        File base = new File(pathBase);
        try {
            FileOutputStream FOS = new FileOutputStream(base, true);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            ArrayList<User> users = new ArrayList<>(user);
            for (User usr : users) {
                if (!searchLoginUser(usr.getLogin())) {
                OOS.writeObject(usr);
                System.out.println("Пользователь добавлен: " + usr);
                } else {
                    System.out.println("Такой пользователь уже есть: " + usr);
                }
            }
            OOS.flush();
            OOS.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        File base = new File(pathBase);
        List<User> users = new ArrayList<>();
        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(base))) {
            while (true) users.add((User) OIS.readObject());
        } catch (IOException | ClassNotFoundException ex) {
        }
        return users;
    }

    //Проверка пользователя в файле
    public boolean searchObjectUserinFile(User user) {
        List<User> allUser = getAllUsers();
        Stream<User> stream = allUser.stream();
        return stream.anyMatch(x-> x.getLogin().equals(user.getLogin()));

    }

    //Поиск пользователя по ID с возвратом объекта User
    @Override
    public User searchUser(Long id) {
        List<User> searchUser = getAllUsers();
        User rUser = null;
        for (User u : searchUser) {
            if (u.getId().equals(id)) rUser = searchUser.get(searchUser.indexOf(u));
        }
        return rUser;
    }

    //Поиск пользователя по логину для проверки на сущестование
    public boolean searchLoginUser(String login) {
        List<User> searchUser = getAllUsers();
        boolean returnable = false;
        for (User u : searchUser) {
            if (u.getLogin().equals(login)) {
                returnable = true;
                break;
            }
        }
        return returnable;
    }

    @Override
    public void deleteUser(User user) {
        if (!pathBase.isEmpty()) ;
        List<User> searchUser = getAllUsers();
        List<User> newList = new ArrayList<>();
        for (User u : searchUser) {
            if (!u.getId().equals(user.getId())) {
                newList.add(u);
            } else {
                System.out.println("Объект удален: " + u);
            }
        }
        try (FileOutputStream fos = new FileOutputStream(pathBase, false)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        addUser(newList);

    }
}


