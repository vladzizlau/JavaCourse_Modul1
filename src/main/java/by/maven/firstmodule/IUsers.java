package by.maven.firstmodule;

import java.io.FileNotFoundException;
import java.util.List;

public interface IUsers
    {
        void addUser(List<User> user);
        abstract User searchUser(Long id);
        abstract List<User> getAllUsers();
        abstract void deleteUser(User user);
    }



