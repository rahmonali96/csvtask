package uz.java.task.db;

import uz.java.task.model.Combined;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {
    public static final String DROP_TABLE = "drop table if exists data";
    public static final String CREATE_TABLE = "create table if not exists data(num bigint primary key, str text)";
    public static final String INSERT = "insert into data(num, str) values (?, ?)";
    private Connection connection;
    private Statement statement;
    private final String url;
    private final String username;
    private final String password;

    public DbHelper(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initilize(List<Combined> combinedList) throws SQLException {
        statement.execute(DROP_TABLE);
        statement.execute(CREATE_TABLE);
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        combinedList.forEach(combined -> {
            try {
                preparedStatement.setInt(1, combined.getInteger());
                preparedStatement.setString(2, combined.getString());
                preparedStatement.execute();
            } catch (SQLException e) {
//                throw new RuntimeException(e);
            }
        });
    }

    public List<String> getNumbers() {
        List<String> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select num from data");
            while (resultSet.next()) {
                list.add(resultSet.getString("num"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getStrings() {
        List<String> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery("select str from data");
            while (resultSet.next()) {
                list.add(resultSet.getString("str"));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
