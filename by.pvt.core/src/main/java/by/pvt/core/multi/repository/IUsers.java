package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;

import java.util.List;

public interface IUsers
    {
         void addUser(List<User> user);
         User searchUser(Long id);
         List<User> getAllUsers();
         void deleteUser(User user);
    }



