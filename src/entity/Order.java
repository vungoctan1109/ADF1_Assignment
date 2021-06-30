package entity;

import util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

public class Order {
    private String id;
    private String nameCustomer;
    private String product;
    private double totalPrice;
    private Date createdAt;
    private int status;

    public Order() {
    }

    public Order(String id, String nameCustomer, String product, double totalPrice) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.product = product;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", product='" + product + '\'' +
                ", totalPrice=" + totalPrice +
                ", createdAt=" + this.getCreatedAtString() +
                ", status=" + this.getStatusName() +
                '}';
    }

    private String getStatusName() {
        if (this.status == 0) {
            return "Deleted";
        } else if (this.status == 1) {
            return "Unpaid";
        }
        return this.status == 2 ? "Paid" : "";
    }

    private String getCreatedAtString() {
        return DateTimeUtil.formatDateToString(this.createdAt);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
