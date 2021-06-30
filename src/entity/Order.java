package entity;

import util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Order {
    private String id;
    private String nameCustomer;
    private String product;
    private double totalPrice;
    private String createdAt;
    private int status;

    public Order() {
    }

    public Order(String id, String nameCustomer, String product, double totalPrice, int status) {
        DateTimeUtil dateFormatted = new DateTimeUtil();
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.product = product;
        this.totalPrice = totalPrice;
        this.createdAt = dateFormatted.formatDateToString(new Date());
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%5s%15s%5s | %5s%15s%5s | %5s%15s%5s | %5s%15s%5s | %5s%15s%5s | %5s%15s%5s\n",
                "", this.id, "",
                "", this.nameCustomer, "",
                "", this.product, "",
                "", this.totalPrice, "",
                "", this.createdAt, "",
                "", this.getStatusName(), "");
    }

    private String getStatusName() {
        if (this.status == 0) {
            return "Deleted";
        } else if (this.status == 1) {
            return "Unpaid";
        }
        return this.status == 2 ? "Paid" : "";
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
