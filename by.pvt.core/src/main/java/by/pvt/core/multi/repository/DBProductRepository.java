package by.pvt.core.multi.repository;

import by.pvt.core.multi.config.PostgressSQL;
import by.pvt.core.multi.domain.Product;
import by.pvt.core.multi.repository.Interface.IProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBProductRepository implements IProduct
    {
    private final PostgressSQL postgressSQL = new PostgressSQL();
    private final String MAX_ID = "select max(id) From store.product";
    private final String ADD_PRODUCT = "insert into store.product (id, type, nameproduct, codeproduct, price) values (?,?,?,?,?)";
    private final String GET_ALL_PRODUCT = "select * From store.product;";
    private final String SEARCH_PRODUCT_FOR_CODE = "select * from store.product p where p.codeproduct = ?";
    private final String SEARCH_PRODUCT_FOR_ID = "select * from store.product p where p.id = ?";
    private final String EDIT_PRODUCT = "update store.product p set type = ?, nameproduct = ?, codeproduct = ?, price = ? where p.id = ?;";
    private final String DELETE_PRODUCT = "delete from store.product p where p.id = ?";


    @Override
    public void addProd(ArrayList<Product> products)
        {
        int lastindex = products.size() - 1;
        Product product = products.get(lastindex);
        Connection connection = null;
        try
            {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            var lastID = resultSet.getLong(1);
            preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setLong(1, ++lastID);
            preparedStatement.setString(2, product.getType());
            preparedStatement.setString(3, product.getNameProduct());
            preparedStatement.setInt(4, product.getCodeProduct());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.execute();
            } catch (SQLException e)
            {
            throw new RuntimeException(e.getMessage());
            } finally
            {
            try
                {
                connection.close();
                } catch (SQLException e)
                {
                throw new RuntimeException(e.getMessage());
                }
            }
        }

    @Override
    public ArrayList<Product> getAllProduct()
        {
        Connection connection = null;
        ArrayList<Product> products = new ArrayList<>();
        try
            {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
                {
                String id = resultSet.getString("id");
                String type = resultSet.getString("type");
                String nameproduct = resultSet.getString("nameproduct");
                String codeproduct = resultSet.getString("codeproduct");
                String price = resultSet.getString("price");

                Product product = new Product(Long.parseLong(id), type, nameproduct, Integer.parseInt(codeproduct), Double.parseDouble(price));
                products.add(product);
                }
            } catch (SQLException e)
            {
            throw new RuntimeException(e.getMessage());
            } finally
            {
            try
                {
                connection.close();
                } catch (SQLException e)
                {
                throw new RuntimeException(e.getMessage());
                }
            }
        return products;
        }

    @Override
    public void editProduct(Product product) {
    Connection connection = null;
    try
        {
        connection = postgressSQL.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT);
        preparedStatement.setString(1, product.getType());
        preparedStatement.setString(2, product.getNameProduct());
        preparedStatement.setInt(3, product.getCodeProduct());
        preparedStatement.setDouble(4, product.getPrice());
        preparedStatement.setLong(5, product.getId());
        preparedStatement.execute();

        } catch (SQLException e)
        {
        throw new RuntimeException(e.getMessage());
        } finally
        {
        try
            {
            connection.close();
            } catch (SQLException e)
            {
            throw new RuntimeException(e.getMessage());
            }
        }
    }
    @Override
    public Product searchForCodeProduct(long codeProd)
        {
        Product prod = null;
        Connection connection = null;
        try
            {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_FOR_CODE);
            preparedStatement.setInt(1, (int) codeProd);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                {
                String id = resultSet.getString("id");
                String type = resultSet.getString("type");
                String nameproduct = resultSet.getString("nameproduct");
                String codeproduct = resultSet.getString("codeproduct");
                String price = resultSet.getString("price");
                prod = new Product(Long.parseLong(id), type, nameproduct, Integer.parseInt(codeproduct), Double.parseDouble(price));
                }
            } catch (SQLException e)
            {
            throw new RuntimeException(e.getMessage());
            } finally
            {
            try
                {
                connection.close();
                } catch (SQLException e)
                {
                throw new RuntimeException(e.getMessage());
                }
            }
        return prod;
        }

    @Override
    public Product searchForIDProduct(long id)
        {
        Product prod = null;
        Connection connection = null;
        try
            {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_FOR_ID);
            preparedStatement.setInt(1, (int) id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                {
                String ids = resultSet.getString("id");
                String type = resultSet.getString("type");
                String nameproduct = resultSet.getString("nameproduct");
                String codeproduct = resultSet.getString("codeproduct");
                String price = resultSet.getString("price");
                prod = new Product(Long.parseLong(ids), type, nameproduct, Integer.parseInt(codeproduct), Double.parseDouble(price));
                }
            } catch (SQLException e)
            {
            throw new RuntimeException(e.getMessage());
            } finally
            {
            try
                {
                connection.close();
                } catch (SQLException e)
                {
                throw new RuntimeException(e.getMessage());
                }
            }
        return prod;
        }

    @Override
    public void deleteProduct(Product product)
        {
        Connection connection = null;
        try
            {
            connection = postgressSQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setLong(1, product.getId());
            preparedStatement.execute();
            } catch (SQLException e)
            {
            throw new RuntimeException(e.getMessage());
            } finally
            {
            try
                {
                connection.close();
                } catch (SQLException e)
                {
                throw new RuntimeException(e.getMessage());
                }
            }
        }

    }
