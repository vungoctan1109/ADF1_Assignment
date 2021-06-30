package controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import entity.Order;
import model.OrderModel;
import model.OrderModelImplement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderControllerImplement implements OrderController {
    private OrderModel orderModel;
    private Scanner scanner;

    public OrderControllerImplement() {
        this.orderModel = new OrderModelImplement();
        this.scanner = new Scanner(System.in);
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
        Order order = new Order(id, nameCustomer, product, totalPrice);
        if (orderModel.save(order)){
            System.out.println("Action success.");
        }else {
            System.out.println("Action failed.");
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
