package com.example.nguyentiennhatnsc.dao;


import com.example.nguyentiennhatnsc.model.User;
import com.example.nguyentiennhatnsc.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    Connection connection = ConnectionUtils.getConnection();

    public User getUser(String username, String password) {
        User user = null;
        String sql = "select * from users where username = '"+username +"' and password = " +password;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String name = rs.getString("username");
                String pass = rs.getString("password");
                user = new User(name, pass);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

}
