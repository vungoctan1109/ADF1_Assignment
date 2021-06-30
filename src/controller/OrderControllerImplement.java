package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Order;
import model.OrderModel;
import model.OrderModelImplement;
import util.DateTimeUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderControllerImplement implements OrderController {
    private OrderModel orderModel;
    private Scanner scanner;

    public OrderControllerImplement() {
        this.orderModel = new OrderModelImplement();
        this.scanner = new Scanner(System.in);
    }

    private Boolean validate(String id, String nameCustomer, String product, double totalPrice, int status) {
        boolean valid =true;
        if (!id.contains("Order")) {
            System.out.println("Invalid Id.");
            valid =false;
        }
        if (nameCustomer.matches(".*\\d.*")) {
            System.out.println("Invalid name customer.");
            valid =false;
        }
        if (product.length() == 0) {
            System.out.println("Invalid product");
            valid =false;
        }
        if (totalPrice < 0) {
            System.out.println("Invalid price");
            valid =false;
        }
        if (status != 1 && status != 2 && status != 0) {
            System.out.println("Invalid status.");
            valid =false;
        }
        return valid;
    }

    @Override
    public void createNewOrder() {
        System.out.println("Please enter order id: ");
        String id = scanner.nextLine();
        System.out.println("Please enter name of customer: ");
        String nameCustomer = scanner.nextLine();
        System.out.println("Please enter product: ");
        String product = scanner.nextLine();
        System.out.println("Please enter total price: ");
        double totalPrice = scanner.nextDouble();
        System.out.println("Please enter status: ");
        int status = scanner.nextInt();
        if (validate(id, nameCustomer, product, totalPrice, status)) {
            Order order = new Order(id, nameCustomer, product, totalPrice, status);
            if (orderModel.save(order)) {
                System.out.println("Action success.");
            } else {
                System.out.println("Action failed.");
            }
        } else {
            System.out.println("Please input valid values.");
        }
    }

    @Override
    public void searchById() {
        System.out.println("Please enter id to search: ");
        String id = scanner.nextLine();
        Order order = orderModel.findById(id);
        if (order == null) {
            System.out.println("Order is not found.");
            return;
        }
        System.out.printf("Found 1 order match that id %s", id);
        System.out.println(order.toString());
    }

    @Override
    public void revenueByTime() {
        DateTimeUtil dateTimeUtil = new DateTimeUtil();
        System.out.println("Please enter start time: ");
        String startTime = scanner.nextLine();
        System.out.println("Please enter end time: ");
        String endTime = scanner.nextLine();
        try {
            Date startDate = dateTimeUtil.parseDateFromString(startTime);
            Date endDate = dateTimeUtil.parseDateFromString(endTime);
            if (startDate.after(endDate)) {
                System.out.println("invalid");
            } else {
                orderModel.revenueByTime(startDate, endDate);
            }
        } catch (Exception e) {
            System.out.println("Invalid input data");
        }
    }

    @Override
    public void showListOrder() {
        List<Order> list = orderModel.findAll();
        System.out.printf("%5s%15s%5s | %5s%15s%5s | %5s%15s%5s | %5s%15s%5s | %5s%15s%5s | %5s%15s%5s\n",
                "", "ID", "",
                "", "Customer Name", "",
                "", "Product", "",
                "", "Total Price", "",
                "", "Created At", "",
                "", "Status", "");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
