package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;

import java.util.List;

public interface IUsers
    {
        abstract void addUser(List<User> user);
        abstract User searchUser(Long id);
        abstract List<User> getAllUsers();
        abstract void deleteUser(User user);
    }



