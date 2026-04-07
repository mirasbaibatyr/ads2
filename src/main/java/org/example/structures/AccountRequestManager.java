package org.example.structures;

import org.example.BankAccount;
import java.util.LinkedList;
import java.util.Queue;

public class AccountRequestManager {
    private Queue<BankAccount> accountRequests = new LinkedList<>();

    public void addRequest(BankAccount account) {
        accountRequests.add(account);
    }

    public BankAccount processRequest() {
        return accountRequests.poll();
    }

    public boolean isEmpty() {
        return accountRequests.isEmpty();
    }
}