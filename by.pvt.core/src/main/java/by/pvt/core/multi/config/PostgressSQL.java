package by.pvt.core.multi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgressSQL {

    public Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/OnlineStore";
            String user = "postgres";
            String password = "sa";
            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        }catch (SQLException e)
        {

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }



}
