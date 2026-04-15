BAIBATYR MIRAS IT-2502 ASSIGMENT 2
Assignment 2 Project Structure
├── BankAccount.java
├── BankSystem.java
│
├── structures/
│   ├── AccountManager.java (LinkedList logic)
│   ├── TransactionManager.java (Stack logic)
│   ├── BillQueueManager.java (Queue logic)
│   ├── AccountRequestManager.java (Queue logic)
│
└── README.md
BankAccount.java
This is the Model class. It defines the structure of a single bank account, storing the account number, username, and balance. It includes a constructor for initialization and a toString() method to format the account details for display.
<img width="1201" height="443" alt="image" src="https://github.com/user-attachments/assets/9109800f-562a-4fef-8f43-a4f95b406051" />

BankSystem.java
This is the Main Entry Point and controller of the application.
<img width="1141" height="903" alt="image" src="https://github.com/user-attachments/assets/b472743d-cfad-4b96-b4d7-24394630045b" />

Initialization: It starts by creating an array of BankAccount objects to demonstrate basic array handling.

Menu Logic: It uses a while loop and switch statements to provide three distinct interfaces: Bank (for user actions), ATM (for balance/withdrawals), and Admin (for system management).

Action Methods: It contains helper methods like depositMoney() and withdrawMoney() to handle the logic of updating account balances.

AccountManager.java
This class manages the storage of active bank accounts using a LinkedList.

It provides methods to add new accounts, search for an account by the owner's name, and iterate through the list to display all active users.
<img width="907" height="881" alt="image" src="https://github.com/user-attachments/assets/ebe12ed6-b28f-4fa9-ae12-317f1b8a938d" />

AccountRequestManager.java
This implements a Queue (FIFO - First In, First Out) to handle new account applications. When a user creates an account in the Bank Menu, it isn't active immediately; it stays in this queue until an Admin approves it.
<img width="919" height="585" alt="image" src="https://github.com/user-attachments/assets/548c75d2-8edb-4204-a3fb-f4e0802ec539" />

BillQueueManager.java
Similar to the request manager, this uses a Queue to manage pending bill payments (e.g., Internet or Electricity). This ensures that bills are processed in the exact order they were received.
<img width="836" height="578" alt="image" src="https://github.com/user-attachments/assets/32c55030-afcf-4af4-bfc4-ecc00cdada8a" />

TransactionManager.java
This class utilizes a Stack (LIFO - Last In, First Out) to track the history of actions.
<img width="954" height="811" alt="image" src="https://github.com/user-attachments/assets/c75d6943-3c95-4df7-83a3-441272e1e50d" />
