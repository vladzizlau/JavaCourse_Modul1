package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.User;
import by.pvt.core.multi.repository.Interface.IUsers;

import java.io.*;
import java.util.*;

public class UserRepository implements IUsers {
    public UserRepository() {
    }

    public String pathBase = "D:\\Project Java\\base.txt";
//    public String pathBase = "D:\\Development Programs\\JavaProject\\base.txt";

    // Добавляет и сохраняет пользователей в файл
    @Override
    public void addUser(ArrayList<User> user) {
        File base = new File(pathBase);
        try {
            FileOutputStream FOS = new FileOutputStream(base);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(user);
            OOS.close();
            FOS.close();
        } catch (IOException e) {
            System.out.println("addUser " + e.getMessage());
        }

    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathBase);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            users = (ArrayList<User>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }




}

