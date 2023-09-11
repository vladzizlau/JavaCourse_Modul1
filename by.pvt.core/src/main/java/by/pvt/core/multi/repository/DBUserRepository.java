package by.pvt.core.multi.repository;

import by.pvt.core.multi.config.PostgressSQL;
import by.pvt.core.multi.domain.User;
import by.pvt.core.multi.repository.Interface.IUsers;

import java.sql.*;
import java.util.ArrayList;

public class DBUserRepository implements IUsers {

    private PostgressSQL postgressSQL = new PostgressSQL();

    private final String ADD_USER = "insert into store.user (id, login, firstname, surname, phonenumber, email, adress, password, role) values (?,?,?,?,?,?,?,?,?)";
    private final String GET_ALL_USERS = "SELECT * FROM store.user";
    private final String MAX_ID = "select max(id) From store.user";
    private final String SEARCH_USER = "select * from store.user u where u.login = ?";
    private final String DELETE_USER = "delete from store.user u where u.login = ?";

public void test ()
{
    Connection connection = postgressSQL.getConnection();
    if (connection != null)
    {
        System.out.println("OK");
    }
    else{
        System.out.println("false");
    }
}

    @Override
    public void addUser(ArrayList<User> users) {
        int lastindex = users.size() - 1;
        User user = users.get(lastindex);
        Connection connection = postgressSQL.getConnection();
        try {
//            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var lastID = resultSet.getLong(1);
            preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setLong(1, ++lastID);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getSurName());
            preparedStatement.setLong(5, user.getPhoneNumber());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getAdress());
            preparedStatement.setString(8, user.getPassword());
            preparedStatement.setString(9, user.getRole());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("addUser: " + e.getMessage());
        } finally {
            try {
                connection.close();
                users.clear();
            } catch (SQLException e) {
                throw new RuntimeException("addUser: " +e.getMessage());
            }
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {
        Connection connection = postgressSQL.getConnection();
        ArrayList<User> users = new ArrayList<>();
        try {
//            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String login = resultSet.getString("login");
                String firstname = resultSet.getString("firstname");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String adress = resultSet.getString("adress");
                String pass = resultSet.getString("password");
                String role = resultSet.getString("role");
                User user = new User(Long.parseLong(id), login, firstname, surname, Long.parseLong(phone), email, pass, role);
                user.setAdress(adress);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("getALLUsers: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("getALLUsers: " + e.getMessage());
            }
        }
        return users;
    }

    @Override
    public User getUser(String login) {
        User rUser = null;

        Connection connection = postgressSQL.getConnection();
        try {
            //connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                String logIn = resultSet.getString("login");
                String firstname = resultSet.getString("firstname");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phonenumber");
                String email = resultSet.getString("email");
                String adress = resultSet.getString("adress");
                String pass = resultSet.getString("password");
                String role = resultSet.getString("role");
                rUser = new User(Long.parseLong(id), logIn, firstname, surname, Long.parseLong(phone), email, pass, role);
                rUser.setAdress(adress);
            }
        } catch (SQLException e) {
            throw new RuntimeException("getUser: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("getUser: " + e.getMessage());
            }
        }
//        System.out.println(rUser.getLogin() + " " + rUser.getPassword());
        return rUser;
    }

    @Override
    public void deleteUser(User user) {
        Connection connection = null;
        try {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("deleteUser: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("deleteUser: " + e.getMessage());
            }
        }
    }


}
