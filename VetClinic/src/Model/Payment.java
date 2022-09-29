package Model;

public class Payment {
    private String paymentId;
    private String customerId;
    private String customerName;
    private String appointmentNo;
    private String date;
    private Double price;

    public Payment() {
    }

    public Payment(String paymentId, String customerId, String customerName, String appointmentNo, String date, Double price) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.appointmentNo = appointmentNo;
        this.date = date;
        this.price = price;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

