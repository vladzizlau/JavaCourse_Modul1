package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface IUsers
    {
         void addUser(ArrayList<User> user);
         ArrayList<User> getAllUsers();

    }



