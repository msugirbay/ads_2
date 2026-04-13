//task1
import java.util.LinkedList;

class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return username + " - Balance: " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<BankAccount> accounts = new LinkedList<>();

       
        accounts.add(new BankAccount("001", "Ali", 150000));
        accounts.add(new BankAccount("002", "Sara", 220000));

        System.out.println("Account added successfully");
        System.out.println();

        
        System.out.println("Accounts List:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i));
        }

        System.out.println();

        String searchName = "Ali";
        boolean found = false;

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(searchName)) {
                System.out.println("Found account: " + acc.username + " - Balance: " + acc.balance);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Account not found");
        }
    }
}
//task2
import java.util.LinkedList;

class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<BankAccount> accounts = new LinkedList<>();

        accounts.add(new BankAccount("001", "Ali", 150000));
        accounts.add(new BankAccount("002", "Sara", 220000));

        String username = "Ali";

        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(username)) {
                System.out.println("Enter username: " + acc.username);

                acc.deposit(50000);
                System.out.println("Deposit: 50000");
                System.out.println("New balance after deposit: " + acc.balance);

                boolean success = acc.withdraw(20000);
                if (success) {
                    System.out.println("Withdraw: 20000");
                    System.out.println("New balance after withdraw: " + acc.balance);
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }
    }
}
//task3
class TransactionStack {
    private String[] stack;
    private int top;

    public TransactionStack(int size) {
        stack = new String[size];
        top = -1;
    }

    public void push(String transaction) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        stack[top] = transaction;
    }

    public String pop() {
        if (top == -1) {
            return null;
        }
        String value = stack[top];
        top--;
        return value;
    }

    public String peek() {
        if (top == -1) {
            return null;
        }
        return stack[top];
    }
}

public class Main {
    public static void main(String[] args) {
        TransactionStack history = new TransactionStack(10);

        history.push("Deposit 50000 to Ali");
        history.push("Withdraw 20000 from Ali");
        history.push("Bill payment: Internet Bill");

        System.out.println("Last transaction: " + history.peek());

        String removed = history.pop();
        System.out.println("Undo -> " + removed + " removed");

        System.out.println("Now last transaction: " + history.peek());
    }
}
//task4
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> billQueue = new LinkedList<>();

        billQueue.offer("Electricity Bill");
        System.out.println("Added: Electricity Bill");

        billQueue.offer("Internet Bill");
        System.out.println("Added: Internet Bill");

        String processed = billQueue.poll();
        System.out.println("Processing: " + processed);

        System.out.println("Remaining bills:");
        for (String bill : billQueue) {
            System.out.println(bill);
        }
    }
}
//task5
import java.util.LinkedList;
import java.util.Queue;

class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return username + " - Balance: " + balance;
    }
}

class AccountRequest {
    String accountNumber;
    String username;
    double balance;

    public AccountRequest(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return username + " - Initial Balance: " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Queue<AccountRequest> accountRequests = new LinkedList<>();
        LinkedList<BankAccount> accounts = new LinkedList<>();

        accountRequests.offer(new AccountRequest("003", "John", 100000));
        System.out.println("Account request added: John");

        System.out.println("\nPending requests:");
        for (AccountRequest req : accountRequests) {
            System.out.println(req);
        }

        AccountRequest processed = accountRequests.poll();
        if (processed != null) {
            accounts.add(new BankAccount(processed.accountNumber, processed.username, processed.balance));
            System.out.println("\nProcessed request for: " + processed.username);
        }

        System.out.println("\nAccounts List:");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }
}
//task6
class BankAccount {
    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public String toString() {
        return "Account Number: " + accountNumber + ", Username: " + username + ", Balance: " + balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount("001", "Ali", 150000);
        accounts[1] = new BankAccount("002", "Sara", 220000);
        accounts[2] = new BankAccount("003", "John", 175000);

        System.out.println("Bank Accounts in Array:");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
    }
}
