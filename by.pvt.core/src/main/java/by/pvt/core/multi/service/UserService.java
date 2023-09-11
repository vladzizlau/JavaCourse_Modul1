package by.pvt.core.multi.service;
//валидация и логика проекта

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.convert.UserConverter;
import by.pvt.core.multi.domain.*;
import by.pvt.core.multi.repository.DBUserRepository;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.service.Interface.IUserService;


import java.util.ArrayList;

public class UserService implements IUserService {
    public long getNewIndex() {
        return System.currentTimeMillis();
    }
    private final DBUserRepository userRepository;
    private final UserConverter userConverter;

    public UserService() {
        userRepository = new DBUserRepository();
        userConverter = new UserConverter();
    }


    public ArrayList <User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @Override
    public boolean register(UserRequest userRequest) //Регистрация
    {
        ArrayList<User> allUsers = getAllUsers();
        User newUser = userConverter.userToEntity(userRequest);
        if (userRepository.getUser(newUser.getLogin()) == null) {
            allUsers.add(newUser);
            userRepository.addUser(allUsers);
            System.out.println("Пользователь добавлен: " + userRequest.getLogin());
            return true;
        } else {
            System.out.println("Такой пользователь уже есть: " + userRequest.getLogin());
            return false;
        }

    }

    @Override
    public UserResponse auth(String login, String password) {
        try {
            User user = userRepository.getUser(login);

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

    @Override
    public User getUser(String login) {
        return userRepository.getUser(login);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }
}

