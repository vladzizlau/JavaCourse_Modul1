package by.pvt.core.multi.repository.Interface;


import by.pvt.core.multi.domain.User;
import java.util.ArrayList;


public interface IUsers
    {
         void addUser(ArrayList<User> user);
         ArrayList<User> getAllUsers();

        //Достаем из базы пользователя
        User getUser(String login);

        void deleteUser(User user);
    }



