package org.example.structures;

import java.util.Stack;

public class TransactionManager {
    private Stack<String> transactionHistory = new Stack<>();

    public void pushTransaction(String log) {
        transactionHistory.push(log);
    }

    public void showLastTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            System.out.println("Last transaction: " + transactionHistory.peek());
        }
    }

    public void undoTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Nothing to undo.");
        } else {
            String removed = transactionHistory.pop();
            System.out.println("Undone: " + removed);
        }
    }
}