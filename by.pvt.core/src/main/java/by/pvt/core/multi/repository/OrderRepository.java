package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.repository.Interface.IOrder;

import java.io.*;
import java.util.ArrayList;

public class OrderRepository implements IOrder {
    public String pathBase = "D:\\Project Java\\orders.txt";
//    public String pathBase = "D:\\Development Programs\\JavaProject\\orders.txt";

    // Сохраняет товар в файл
    @Override
    public void addOrder(Order order) {
        ArrayList<Order> newlist = getOrdersList();
        newlist.add(order);
        saveToFile(newlist);
        // Здесь место под функцию сохранения ордера в базу данных
    }

    @Override
    public void saveToFile(ArrayList<Order> orderlist) //сохранение в файл
    {
        try {
            FileOutputStream FOS = new FileOutputStream(pathBase);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(orderlist);
            OOS.close();
            FOS.close();
        } catch (Throwable e) {
            System.out.println("addOrder: " + e.getMessage());
        }
    }

    public ArrayList<Order> getOrdersList() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(pathBase);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            orders = (ArrayList<Order>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
        }
        return orders;
    }
}
