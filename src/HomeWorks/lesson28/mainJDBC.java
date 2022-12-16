package HomeWorks.lesson28;

import HomeWorks.lesson28.util.Database;

import java.sql.Connection;

public class mainJDBC {
    public static void main(String[] args) {
        Connection connection = Database.getConnection();
    }
}
