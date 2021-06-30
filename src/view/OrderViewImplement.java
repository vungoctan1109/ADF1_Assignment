package view;

import controller.OrderController;
import controller.OrderControllerImplement;

import java.util.Scanner;

public class OrderViewImplement implements OrderView {
    private OrderController orderController;
    private Scanner scanner;

    public OrderViewImplement() {
        this.orderController = new OrderControllerImplement();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void generateMenu() {
        while (true) {
            System.out.println("Order Manager");
            System.out.println("-------------------------------");
            System.out.println("1.Add new order.");
            System.out.println("2.Show list order.");
            System.out.println("3.Search order by id.");
            System.out.println("4.Revenue by time.");
            System.out.println("5.Exit");
            System.out.println("-------------------------------");
            System.out.println("Please enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    orderController.createNewOrder();
                    break;
                case 2:
                    orderController.showListOrder();
                    break;
                case 3:
                    orderController.searchById();
                    break;
                case 4:
                    orderController.revenueByTime();
                    break;
                case 5:
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please chose again.");
                    break;
            }
            if (choice == 5) {
                break;
            }
            scanner.nextLine();
        }
    }
}
