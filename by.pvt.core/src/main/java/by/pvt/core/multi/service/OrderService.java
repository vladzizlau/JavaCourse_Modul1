package by.pvt.core.multi.service;

import by.pvt.core.multi.config.ApplicationContext;
import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.domain.Status;
import by.pvt.core.multi.repository.DBOrderRepository;
import by.pvt.core.multi.repository.OrderRepository;
import by.pvt.core.multi.service.Interface.IOrderService;


import java.util.ArrayList;

public class OrderService implements IOrderService {
    // id, userId, cost, status=НЕ_СФОРМИРОВАН
    private final DBOrderRepository orderRepository;

    public OrderService() {
        orderRepository = new DBOrderRepository();
    }

    @Override
    public long order(long userId) //Входная функция по получению id ордера
    {
        Order order = searchCurrentOrder(userId);
        Order newOrder = null;
        if (order  == null) {
            newOrder = createOrder(userId);
            return newOrder.getId();
        } else if (order != null) {
            return order.getId();
        }
        return order.getId();
    }

    @Override
    public Order createOrder(long userId) { //создадим новый ордер и вернем его в работу
        long thisOrderId = System.currentTimeMillis();
        Order order = new Order(thisOrderId, userId, 0, Status.НЕ_СФОРМИРОВАН);
        return orderRepository.addOrder(order);
    }
    @Override
    public void editOrderStatus(long userID, Status status){ //Изменение статуса
        Order order = orderRepository.searchCurrentOrder(userID);
        double cost = ApplicationContext.getInstance().getCartService().finalCost(order.getId());
        orderRepository.editStatusOrder(order, status, cost);
    }
    @Override
    public Order searchCurrentOrder(long userID) { //Получим ордер со статусом НЕ_СФОРМИРОВАН"
                return orderRepository.searchCurrentOrder(userID);
    }
    @Override
    public ArrayList<Order> getAllUserOrders(long userId) { //Получет все ордеры пользователя
        return orderRepository.getAllUserOrders(userId);
    }

    @Override
    public ArrayList<Order> getAllOrder() {
        return orderRepository.getOrdersList();
    }
}
