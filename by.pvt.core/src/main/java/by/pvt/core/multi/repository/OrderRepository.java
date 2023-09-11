package by.pvt.core.multi.repository;

import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.repository.Interface.IOrder;
import by.pvt.core.multi.domain.Status;

import java.io.*;
import java.util.ArrayList;

public class OrderRepository implements IOrder {
    public String pathBase = "D:\\Project Java\\orders.txt";
//    public String pathBase = "D:\\Development Programs\\JavaProject\\orders.txt";

    // Сохраняет товар в файл


    public Order addOrder(Order order) {
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        try {
            FileOutputStream FOS = new FileOutputStream(pathBase);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(orders);
            OOS.close();
            FOS.close();
        } catch (Throwable e) {
            System.out.println("addOrder: " + e.getMessage());
        }
        return order;
    }

    @Override
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

    @Override
    public Order searchCurrentOrder(long userID) { //Получим ордер со статусом НЕ_СФОРМИРОВАН"
        for (Order o : getAllUserOrders(userID)) {
            if (o.getStatus().equals(Status.НЕ_СФОРМИРОВАН))
                return o;
        }
        return null;
    }

    @Override
    public ArrayList<Order> getAllUserOrders(long userId) { //Получет все ордеры пользователя
        ArrayList<Order> allOrders = new ArrayList<>();
        for (Order order : getOrdersList()) {
            if (order.getUserId() == userId) {
                allOrders.add(order);
            }
        }
        return allOrders;
    }


    @Override
    public void editStatusOrder(Order order, Status status, double cost) { //Присвоение статуса оплачен
        ArrayList<Order> allOrders = getOrdersList();
        int index = 0;

        for (int i = 0; i < allOrders.size(); ) {
            if (allOrders.get(i).getId() == order.getId()) {
                index = i;
                break;
            }
            i++;
        }

        allOrders.get(index).setStatus(status);
        allOrders.get(index).setCost(cost);
//Далее сохраняем в файл
        try {
            FileOutputStream FOS = new FileOutputStream(pathBase);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(allOrders);
            OOS.close();
            FOS.close();
        } catch (Throwable e) {
            System.out.println("addOrder: " + e.getMessage());
        }
    }


}
