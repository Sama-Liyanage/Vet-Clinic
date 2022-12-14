package Controller;



import Model.User;
import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController {
    //check the validity of username
    public static boolean checkValidity(String userName) throws SQLException, ClassNotFoundException {
        String sql = "Select * from user where userName='" + userName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return false;
        } else {
            return true;
        }
    }

    //check whether the username and password is correct
    public static boolean checkUser(User user) throws SQLException, ClassNotFoundException{
        String sql = "Select * from user where userName='" + user.getUsername() + "' && password='" + user.getPassword() + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        String role = null;
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            return true;
        } else {
            return false;
        }
    }

    //add new user
    public static boolean addUser(User user)throws SQLException, ClassNotFoundException{
        String sql = "Insert into user values('" + user.getUserId() + "','" + user.getUsername() + "','" + user.getPassword() + "')";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;
    }
}
