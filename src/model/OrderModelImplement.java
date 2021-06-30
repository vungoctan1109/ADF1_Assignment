package model;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderModelImplement implements OrderModel {
    private List<Order> list;

    {
        list = new ArrayList<>();
        list.add(new Order("Order001", "Vu Ngoc Tan", "1 can gao", 100000));
        list.add(new Order("Order002", "Vu Ngoc Tuan", "2 can tao", 200000));
        list.add(new Order("Order003", "Vu Ngoc Tun", "1 can ca chua", 400000));
        list.add(new Order("Order004", "Vu Ngoc Tang", "1 can khoai", 500000));
        list.add(new Order("Order005", "Vu Ngoc Tu", "2 can dua", 200000));
        list.add(new Order("Order006", "Vu Ngoc Trinh", "4 can xoai", 300000));
        list.add(new Order("Order007", "Vu Ngoc Trang", "1 can vai", 600000));
        list.add(new Order("Order008", "Vu Ngoc Thuy", "2 can chuoi", 50000));
    }

    public OrderModelImplement() {
        this.list = new ArrayList<>();

    }

    @Override
    public boolean save(Order obj) {
        list.add(obj);
        return true;
    }

    @Override
    public Order findById(String id) {
        Order order = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                order = list.get(i);
                break;
            }
        }
        return order;
    }

    @Override
    public List<Order> revenueByTime() {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return list;
    }
}
