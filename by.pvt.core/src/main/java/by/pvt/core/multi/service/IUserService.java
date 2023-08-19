package by.pvt.core.multi.service;

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.domain.User;

public interface IUserService
    {
    public void register(UserRequest u);
    public UserResponse auth(String l, String p);

        //Поиск пользователя по ID с возвратом объекта User
        User searchUser(Long id);

        void deleteUser(User user);
    }
