package by.pvt.core.multi.service;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.service.Interface.IOrderService;


import java.util.ArrayList;

public class OrderService implements IOrderService {
    // id, userId, cost, status=НЕ_СФОРМИРОВАН

    @Override
    public long order(long userId) //Входная функция по получению id ордера
    {
        long orderid = searchCurrentOrder(userId);
        if (orderid == -1) {
            orderid = createOrder(userId);
        } else if (orderid != -1) {
            return orderid;
        }
        return orderid;
    }

    @Override
    public long createOrder(long userId) { //создадим новый ордер и вернем его id
        long thisOrderId = System.currentTimeMillis();
        Order ord = new Order(thisOrderId, userId, 0, "НЕ_СФОРМИРОВАН");
        ApplicationContext.getInstance().getOrderRepository().addOrder(ord);
        return thisOrderId;
    }

    public void editOrder(long userID, String status){ //Присвоение статуса оплачен
        long orderid = searchCurrentOrder(userID);
        double cost = ApplicationContext.getInstance().getCartService().finalCost(orderid);
        ArrayList<Order> allorders = getAllOrder();
        int index = 0;
        Order order = new Order();
        for(int i = 0; i < allorders.size();)
        {
                if(allorders.get(i).getId() == orderid)
                {
                    index = i;
                    break;
                }
            i++;
        }
//        int index = allorders.indexOf(order);
        allorders.get(index).setStatus(status);
        allorders.get(index).setCost(cost);
        ApplicationContext.getInstance().getOrderRepository().saveToFile(allorders);
    }
    @Override
    public long searchCurrentOrder(long userID) { //Получим ордер со статусом НЕ_СФОРМИРОВАН"
        for (Order order : getAllUserOrders(userID)) {
            if (order.getStatus().equals("НЕ_СФОРМИРОВАН")) {
                return order.getId();
            }
        }
        return -1;
    }
    @Override
    public ArrayList<Order> getAllUserOrders(long userId) { //Получет все ордеры пользователя
        ArrayList<Order> allOrders = new ArrayList<>();
        for (Order order : getAllOrder()) {
            if (order.getUserId() == userId) {
                allOrders.add(order);
            }
        }
        return allOrders;
    }

    @Override
    public ArrayList<Order> getAllOrder() {
        return ApplicationContext.getInstance().getOrderRepository().getOrdersList();
    }
}
