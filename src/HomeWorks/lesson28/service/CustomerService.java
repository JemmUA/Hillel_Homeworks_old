package HomeWorks.lesson28.service;

import HomeWorks.lesson28.entity.Customer;
import HomeWorks.lesson28.util.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                //init settings
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

}
