package by.pvt.core.multi.service;
//валидация и логика проекта

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.*;
import by.pvt.core.multi.service.Interface.IUserService;

import java.util.ArrayList;

public class UserService implements IUserService {


    public long getNewIndex() {
        return System.currentTimeMillis();
    }

    public ArrayList <User> getAllUsers(){
        return ApplicationContext.getInstance().getUserRepository().getAllUsers();
    }

    @Override
    public void register(UserRequest userRequest) //Регистрация
    {
        ArrayList<User> allUsers = getAllUsers();
        User newUser = ApplicationContext.getInstance().getUserConverter().userToEntity(userRequest);
        if (!searchLoginUser(newUser.getLogin())) {
            allUsers.add(newUser);
            ApplicationContext.getInstance().getUserRepository().addUser(allUsers);
            System.out.println("Пользователь добавлен: " + userRequest.getLogin());
        } else {
            System.out.println("Такой пользователь уже есть: " + userRequest.getLogin());
        }
    }

    @Override
    public UserResponse auth(String login, String password) {
        try {
            User user = getUser(login);

            if (user != null && user.getPassword().equalsIgnoreCase(password)) {
                System.out.println("Логин и пароль совпадают");
                return ApplicationContext.getInstance().getUserConverter().userToDTO(user);
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
        ArrayList<User> searchUser = getAllUsers();
        User rUser = null;
        for (User u : searchUser) {
            if (u.getId().equals(id)) rUser = searchUser.get(searchUser.indexOf(u));
        }
        return rUser;
    }

    @Override
    //Поиск пользователя по логину для проверки на сущестование
    public boolean searchLoginUser(String login) {
       ArrayList<User> searchUser = getAllUsers();
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
        ArrayList<User> temp = getAllUsers();
        temp.removeIf(s -> s.getId() == user.getId());
        ApplicationContext.getInstance().getUserRepository().addUser(temp);

    }
}

