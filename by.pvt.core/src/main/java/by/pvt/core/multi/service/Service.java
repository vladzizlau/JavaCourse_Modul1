package by.pvt.core.multi.service;
//валидация и логика проекта

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.convert.MapUser;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Service
    {

    public void register(UserRequest userRequest) //Регистрация
        {
        MapUser mapUser = new MapUser();
        UserRepository userRepository = new UserRepository();
        List<User> userList = new ArrayList<User>();
        userList.add(mapUser.userToEntity(userRequest));
         userRepository.addUser(userList);
        }

        public UserResponse auth(String login, String password) //Авторизация
        {
            UserRepository userRepository = new UserRepository();
            MapUser mapUser = new MapUser();
            return mapUser.userToDTO(userRepository.getUser(login, password));
        }


    }
