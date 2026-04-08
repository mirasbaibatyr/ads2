package org.example;

import org.example.structures.*;
import java.util.Scanner;

public class BankSystem {
    static AccountManager accountManager = new AccountManager();
    static TransactionManager transactionManager = new TransactionManager();
    static BillQueueManager billManager = new BillQueueManager();
    static AccountRequestManager requestManager = new AccountRequestManager();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Array");
        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount("1", "Miras1", 150000);
        arr[1] = new BankAccount("2", "Miras2", 220000);
        arr[2] = new BankAccount("3", "Miras3", 50000);

        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i].toString());
            accountManager.addAccount(arr[i]);
        }

        boolean running = true;

        while (running) {
            System.out.println("\n Main Menu");
            System.out.println("1.Bank");
            System.out.println("2.ATM");
            System.out.println("3.Admin");
            System.out.println("4.Exit");
            System.out.print("Choose");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bankMenu();
                    break;
                case 2:
                    atmMenu();
                    break;
                case 3:
                    adminMenu();
                    break;
                case 4:
                    running = false;
                    System.out.println("end sys");
                    break;
                default:
                    System.out.println("Wrong num");
                    break;
            }
        }
    }

    static void bankMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n Bank Menu");
            System.out.println("1.new account");
            System.out.println("2.Deposit money");
            System.out.println("3.Withdraw money");
            System.out.println("4.Pay a bill (add to queue)");
            System.out.println("5.Back");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter starting balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    String newAccNumber = "200" + (accountManager.getAccountCount() + 1);
                    BankAccount newAcc = new BankAccount(newAccNumber, name, balance);
                    requestManager.addRequest(newAcc);
                    System.out.println("Request sent to Admin");
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.print("Enter bill name (Internet, Electricity, etc.): ");
                    String bill = scanner.nextLine();
                    billManager.addBill(bill);
                    transactionManager.pushTransaction("Added bill to queue: " + bill);
                    System.out.println("Bill added successfully.");
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    static void atmMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n ATM Menu");
            System.out.println("1.Check balance");
            System.out.println("2.Withdraw money");
            System.out.println("3.Back");
            System.out.print("Choice");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    BankAccount acc = accountManager.findAccount(name);
                    if (acc != null) {
                        System.out.println("balance: " + acc.balance);
                    } else {
                        System.out.println("User not found");
                    }
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    static void adminMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n Admin Panel");
            System.out.println("1.Approve account requests");
            System.out.println("2.Process bill queue");
            System.out.println("3.Show all active accounts");
            System.out.println("4.Show last transaction (Peek)");
            System.out.println("5.Undo transaction (Pop)");
            System.out.println("6.Back");
            System.out.print("Choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (requestManager.isEmpty()) {
                        System.out.println("No new requests.");
                    } else {
                        while (!requestManager.isEmpty()) {
                            BankAccount newAcc = requestManager.processRequest();
                            accountManager.addAccount(newAcc);
                            System.out.println("Approved account for: " + newAcc.username);
                        }
                    }
                    break;
                case 2:
                    if (billManager.isEmpty()) {
                        System.out.println("Bill queue is empty.");
                    } else {
                        String bill = billManager.processBill();
                        System.out.println("Paid bill: " + bill);
                        transactionManager.pushTransaction("Paid bill: " + bill);
                    }
                    break;
                case 3:
                    System.out.println("Account List:");
                    accountManager.showAllAccounts();
                    break;
                case 4:
                    transactionManager.showLastTransaction();
                    break;
                case 5:
                    transactionManager.undoTransaction();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
    }

    static void depositMoney() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        BankAccount acc = accountManager.findAccount(name);

        if (acc != null) {
            System.out.print("Amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            acc.balance = acc.balance + amount;

            String log = "Deposit " + amount + " to " + name;
            transactionManager.pushTransaction(log);

            System.out.println("New balance: " + acc.balance);
        } else {
            System.out.println("User not found");
        }
    }

    static void withdrawMoney() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        BankAccount acc = accountManager.findAccount(name);

        if (acc != null) {
            System.out.print("Amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (acc.balance >= amount) {
                acc.balance = acc.balance - amount;

                String log = "Withdraw " + amount + " from " + name;
                transactionManager.pushTransaction(log);

                System.out.println("New balance: " + acc.balance);
            } else {
                System.out.println("Not enough money");
            }
        } else {
            System.out.println("User not found");
        }
    }
}