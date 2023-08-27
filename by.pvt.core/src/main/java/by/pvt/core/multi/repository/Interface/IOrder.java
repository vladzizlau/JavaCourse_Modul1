package by.pvt.core.multi.repository.Interface;

import by.pvt.core.multi.domain.Order;

import java.util.ArrayList;

public interface IOrder {


    // Сохраняет товар в файл
    void addOrder(Order order);
    void saveToFile(ArrayList<Order> orderlist);
    public ArrayList<Order> getOrdersList();
}
