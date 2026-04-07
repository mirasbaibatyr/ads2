package org.example.structures;

import org.example.BankAccount;
import java.util.LinkedList;

public class AccountManager {
    private LinkedList<BankAccount> accounts = new LinkedList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount findAccount(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount currentAccount = accounts.get(i);
            if (currentAccount.username.equalsIgnoreCase(name)) {
                return currentAccount;
            }
        }
        return null;
    }

    public void showAllAccounts() {
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).toString());
        }
    }

    public int getAccountCount() {
        return accounts.size();
    }
}
