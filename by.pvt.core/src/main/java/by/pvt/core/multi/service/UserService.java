package by.pvt.core.multi.service;
//валидация и логика проекта

import by.pvt.api.dto.UserRequest;
import by.pvt.api.dto.UserResponse;
import by.pvt.core.multi.convert.UserConverter;
import by.pvt.core.multi.repository.ProductRepository;
import by.pvt.core.multi.repository.UserRepository;
import by.pvt.core.multi.domain.*;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService
    {
    UserRepository userRepository;
    ProductRepository productRepository;
    UserConverter userConverter;

    public UserService()
        {
        userRepository = new UserRepository();
        productRepository = new ProductRepository();
        }
@Override
    public void register(UserRequest userRequest) //Регистрация
{
userConverter = new UserConverter();
List<User> userList = new ArrayList<User>();
userList.add(userConverter.userToEntity(userRequest));
if (!userRepository.searchLoginUser(userRequest.getLogin()))
    {
    userRepository.addUser(userList);
    System.out.println("Пользователь добавлен: " + userRequest.getLogin());
    }
else
    {
    System.out.println("Такой пользователь уже есть: " + userRequest.getLogin());
    }
}
    @Override
        public UserResponse auth(String login, String password)
        {
        userRepository = new UserRepository();
            userConverter = new UserConverter();
            try
                {
                User user = userRepository.getUser(login);
                if (user.getLogin().equals(login) && user.getPassword().equals(password))
                    {
                    System.out.println("Логин и пароль совпадают");
                    return userConverter.userToDTO(userRepository.getUser(login));
                    }
                else
                    {
                    System.out.println("Логин или пароль не совпадают");
                    return null;
                    }
                }
                catch (NullPointerException e) { System.out.println(e);}
return null;
        }
}

