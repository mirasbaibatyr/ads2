package org.example.structures;

import java.util.LinkedList;
import java.util.Queue;

public class BillQueueManager {
    private Queue<String> billQueue = new LinkedList<>();

    public void addBill(String bill) {
        billQueue.add(bill);
    }

    public String processBill() {
        return billQueue.poll();
    }

    public boolean isEmpty() {
        return billQueue.isEmpty();
    }
}