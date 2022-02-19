package com.example.tut02.dao;

import com.example.tut02.dbconnect.DBConnect;
import com.example.tut02.entity.Friend;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO {
    //establish db connection
//    private String URL;
//    private String USERNAME;
//    private String PASSWORD;
    private Connection connection;

    public FriendDAO() {
        connection = DBConnect.getConnection();
    }

//    public FriendDAO(String URL, String USERNAME, String PASSWORD) {
//        this.URL = URL;
//        this.USERNAME = USERNAME;
//        this.PASSWORD = PASSWORD;
//    }
//
//    protected void connect() throws SQLException {
//        if (connection == null || connection.isClosed()) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                throw new SQLException(e);
//            }
//            connection = DriverManager.getConnection(
//                    URL, USERNAME, PASSWORD);
//        }
//    }
//
//    protected void disconnect() throws SQLException {
//        if (connection != null && !connection.isClosed()) {
//            connection.close();
//        }
//    }

    //READ: to select data from table in db
    public List<Friend> selectFriend() {
        List<Friend> friendList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM friend";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String sex = resultSet.getString(4);
                String city = resultSet.getString("city");
                Friend friend = new Friend(id, name, age, sex, city);
                friendList.add(friend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return friendList;
    }

    //CREATE
    public boolean addFriend(Friend friend) throws SQLException {
        boolean rowInserted = false;
        String sql = "INSERT INTO friend(name, age, sex, city) VALUES (?, ?, ?, ?)";
//        connect();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, friend.getName());
        preparedStatement.setInt(2, friend.getAge());
        preparedStatement.setString(3, friend.getSex());
        preparedStatement.setString(4, friend.getCity());

        rowInserted = preparedStatement.executeUpdate() > 0;


        preparedStatement.close();
//        disconnect();
        return rowInserted;


    }

    //UPDATE
    public boolean updateFriend(Friend friend) throws SQLException {
        boolean rowUpdated = false;
        String sql = "UPDATE friend SET name = ?, age = ?, sex = ?, city = ?";
        sql += " WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, friend.getName());
        preparedStatement.setInt(2, friend.getAge());
        preparedStatement.setString(3, friend.getSex());
        preparedStatement.setString(4, friend.getCity());
        preparedStatement.setInt(5, friend.getId());

        rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return rowUpdated;
    }

    //DELETE
    public boolean deleteFriend(Friend friend) throws SQLException {
        String sql = "DELETE FROM friend where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, friend.getId());

        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return rowDeleted;
    }

    //Get Friend
    public Friend getFriend(int id) throws SQLException {
        Friend friend = null;
        String sql = "SELECT * FROM friend WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String sex = resultSet.getString("sex");
            String city = resultSet.getString("city");

            friend = new Friend(id, name, age, sex, city);
        }

        resultSet.close();
        preparedStatement.close();

        return friend;
    }
}
