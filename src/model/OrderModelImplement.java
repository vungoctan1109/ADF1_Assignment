package model;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Order;
import util.DateTimeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModelImplement implements OrderModel {
    private List<Order> list;

    {
        list = new ArrayList<>();
        list.add(new Order("Order001", "Vu Ngoc Tan", "1 can gao", 100000, 1));
        list.add(new Order("Order002", "Vu Ngoc Tuan", "2 can tao", 200000,2));
        list.add(new Order("Order003", "Vu Ngoc Tun", "1 can ca chua", 400000,0));
        list.add(new Order("Order004", "Vu Ngoc Tang", "1 can khoai", 500000,0));
        list.add(new Order("Order005", "Vu Ngoc Tu", "2 can dua", 200000,1));
        list.add(new Order("Order006", "Vu Ngoc Trinh", "4 can xoai", 300000,2));
        list.add(new Order("Order007", "Vu Ngoc Trang", "1 can vai", 600000,1));
        list.add(new Order("Order008", "Vu Ngoc Thuy", "2 can chuoi", 50000,2));
    }

    public OrderModelImplement() {
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
    public void revenueByTime(Date startDate , Date endDate) {
        Boolean noMatchedOrder = true;
        DateTimeUtil dateTimeUtil = new DateTimeUtil();
        double totalPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            Date createDate = dateTimeUtil.parseDateFromString(list.get(i).getCreatedAt());
            if (!createDate.before(startDate) && !createDate.after(endDate) && list.get(i).getStatus() == 2) {
                System.out.println(findById(list.get(i).getId()));
                noMatchedOrder =false;
                totalPrice += list.get(i).getTotalPrice();
            }
        }
        System.out.printf("Total Price: %.2f", totalPrice);
        if (noMatchedOrder) {
            System.out.println("No match order");
        }
    }

    @Override
    public List<Order> findAll() {
        return list;
    }
}
