package by.pvt.core.multi.service;
//валидация и логика проекта

import by.pvt.api.dto.UserRequest;
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

        public void Auth(User user) //Авторизация
        {
            MapUser mapUser = new MapUser();
            UserRepository userRepository = new UserRepository();
            User newUser = userRepository.getUser(user.getLogin(), user.getPassword());
            mapUser.userToDTO(newUser);

        }


    }
