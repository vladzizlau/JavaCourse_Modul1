package by.pvt.core.multi.repository;

import by.pvt.core.multi.config.PostgressSQL;
import by.pvt.core.multi.domain.Order;
import by.pvt.core.multi.domain.Status;
import by.pvt.core.multi.repository.Interface.IOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBOrderRepository implements IOrder {

    private final PostgressSQL postgressSQL = new PostgressSQL();
    private final String ADD_ORDER = "insert into store.order (id, userid, cost, status) values (?,?,?,?)";
    private final String GET_ORDER_LIST = "SELECT * FROM store.order";
    private final String MAX_ID = "select max(id) From store.order";
    private final String SEARCH_CURRENT_ORDER = "select * from store.order o where o.userid = ? and o.status = ?";
    private final String GET_ALL_USER_ORDERS = "select * from store.order o where o.userid = ?";
    private final String EDIT_STATUS_ORDER = "update store.order set cost = ?, status = ? where id = ?";

    @Override
    public Order addOrder(Order order) {
        Connection connection = null;
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var lastID = resultSet.getLong(1);
            preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setLong(1, ++lastID);
            preparedStatement.setLong(2, order.getUserId());
            preparedStatement.setDouble(3, order.getCost());
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return order;
    }

    @Override
    public ArrayList<Order> getOrdersList() {
        Connection connection = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userid = resultSet.getString("userid");
                String cost = resultSet.getString("cost");
                String status = resultSet.getString("status");
                Order order = new Order(Long.parseLong(id), Long.parseLong(userid), Double.parseDouble(cost), Status.valueOf(status));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return orders;
    }

    @Override
    public Order searchCurrentOrder(long userID) {
        Order order = null;
        Connection connection = null;
                try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CURRENT_ORDER);
            preparedStatement.setLong(1, userID);
            preparedStatement.setString(2, String.valueOf(Status.НЕ_СФОРМИРОВАН));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userid = resultSet.getString("userid");
                String cost = resultSet.getString("cost");
                String status = resultSet.getString("status");
                order = new Order(Long.parseLong(id), Long.parseLong(userid), Double.parseDouble(cost), Status.valueOf(status));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return order;
    }

    @Override
    public ArrayList<Order> getAllUserOrders(long userId) {
        Connection connection = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER_ORDERS);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userid = resultSet.getString("userid");
                String cost = resultSet.getString("cost");
                String status = resultSet.getString("status");
                Order order = new Order(Long.parseLong(id), Long.parseLong(userid), Double.parseDouble(cost), Status.valueOf(status));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return orders;
    }

    @Override
    public void editStatusOrder(Order order, Status status, double cost) {
        Connection connection = null;
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_STATUS_ORDER);
            preparedStatement.setDouble(1, cost);
            preparedStatement.setString(2, String.valueOf(status));
            preparedStatement.setLong(3, order.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

    }
}
