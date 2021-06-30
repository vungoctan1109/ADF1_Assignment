package model;

import entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderModel {
    boolean save(Order obj);

    Order findById(String id);

    void revenueByTime(Date start, Date end);

    List<Order> findAll();
}
