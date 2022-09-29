package Controller;

import Model.Customer;
import Model.Payment;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentController {
    public static boolean addPayment(Payment payment)throws SQLException, ClassNotFoundException{
        String sql = "Insert into payment values(?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, payment.getPaymentId());
        stm.setObject(2, payment.getCustomerId());
        stm.setObject(3, payment.getCustomerName());
        stm.setObject(4, payment.getAppointmentNo());
        stm.setObject(5, payment.getDate());
        stm.setObject(6, payment.getPrice());
        int res = stm.executeUpdate();
        return res > 0;
    }
}
