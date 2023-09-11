package by.pvt.core.multi.repository;

import by.pvt.core.multi.config.PostgressSQL;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.domain.ShopCart;
import by.pvt.core.multi.repository.Interface.IShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBShopRepository implements IShop {
    private final PostgressSQL postgressSQL = new PostgressSQL();
    private final String MAX_ID = "select max(id) From store.shopcart";
    private final String ADD_SHOPCART = "insert into store.shopcart (id, productid, orderid, nameproduct, count, cost) values (?,?,?,?,?,?)";
    private final String GET_CART_LIST = "select * From store.shopcart";
    @Override
    public void addOrder(ShopCart shopCart) {
        Connection connection = null;
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var lastID = resultSet.getLong(1);
            preparedStatement = connection.prepareStatement(ADD_SHOPCART);
            preparedStatement.setLong(1, ++lastID);
            preparedStatement.setLong(2, shopCart.getProductId());
            preparedStatement.setLong(3, shopCart.getOrderId());
            preparedStatement.setString(4, shopCart.getNameProduct());
            preparedStatement.setDouble(5, shopCart.getCount());
            preparedStatement.setDouble(6, shopCart.getCost());
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

    @Override
    public ArrayList<ShopCart> getCartList() {
        Connection connection = null;
        ArrayList<ShopCart> shops = new ArrayList<>();
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String productid = resultSet.getString("productid");
                String orderid = resultSet.getString("orderid");
                String nameproduct = resultSet.getString("nameproduct");
                String count = resultSet.getString("count");
                String cost = resultSet.getString("cost");

                ShopCart shopCart = new ShopCart(Long.parseLong(id), nameproduct, Long.parseLong(productid), Integer.parseInt(count), Double.parseDouble(cost), Long.parseLong(orderid));
                shops.add(shopCart);
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
        return shops;
    }
}
