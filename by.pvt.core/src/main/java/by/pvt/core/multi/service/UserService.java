package by.pvt.core.multi.service;
//валидация и логика проекта

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.convert.UserConverter;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.domain.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserService implements IUserService {
    ApplicationContext applicationContext;
    UserRepository userRepository;
    UserConverter userConverter;


    public long getNewIndex() {
        return System.currentTimeMillis();
    }

    public ArrayList <User> getAllUsers(){
        userRepository = new UserRepository();
        return userRepository.getAllUsers();
    }

    @Override
    public void register(UserRequest userRequest) //Регистрация
    {
        userConverter = new UserConverter();
        userRepository = new UserRepository();
        ArrayList<User> allUsers = getAllUsers();
       // User newUser = applicationContext.getUserConverter().userToEntity(userRequest);
        User newUser = userConverter.userToEntity(userRequest);
        if (!searchLoginUser(newUser.getLogin())) {
            allUsers.add(newUser);
            userRepository.addUser(allUsers);
            System.out.println("Пользователь добавлен: " + userRequest.getLogin());
        } else {
            System.out.println("Такой пользователь уже есть: " + userRequest.getLogin());
        }

    }

    @Override
    public UserResponse auth(String login, String password) {
        userConverter = new UserConverter();
        try {
            User user = getUser(login);

            if (user != null && user.getPassword().equalsIgnoreCase(password)) {
                System.out.println("Логин и пароль совпадают");
                return userConverter.userToDTO(user);
            } else {
                System.out.println("Логин или пароль не совпадают");
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return null;
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

    //Достаем из базы пользователя
    public User getUser(String login) {
        User rUser = null;
        for (int i = 0; i<getAllUsers().size();) {
            if(getAllUsers().get(i).getLogin().equalsIgnoreCase(login))
            {
                rUser = getAllUsers().get(i);
                break;
            } else {
                System.out.println("Такого пользователя нет в БД");
            }
            i++;
        }
        return rUser;
    }

    @Override
    public void deleteUser(User user) {
        applicationContext = new ApplicationContext();
        ArrayList<User> temp = getAllUsers();
        temp.removeIf(s -> s.getId() == user.getId());
        applicationContext.getUserRepository().addUser(temp);

    }
}

