package model;

import entity.Order;

import java.util.List;

public interface OrderModel {
    boolean save (Order obj);
    Order findById(String id);
    List<Order> revenueByTime();
    List<Order> findAll();
}
