import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    public String toString() {
        return username + " - Balance: " + balance;
    }
}

class TransactionStack {
    private String[] stack;
    private int top;

    public TransactionStack(int size) {
        stack = new String[size];
        top = -1;
    }

    public void push(String transaction) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = transaction;
        }
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

class AccountRequest {
    String accountNumber;
    String username;
    double balance;

    public AccountRequest(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        Queue<String> billQueue = new LinkedList<>();
        Queue<AccountRequest> requestQueue = new LinkedList<>();
        TransactionStack history = new TransactionStack(20);

        accounts.add(new BankAccount("001", "Ali", 150000));
        accounts.add(new BankAccount("002", "Sara", 220000));

        int choice;

        do {
            System.out.println("\n1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("\nBANK MENU");
                System.out.println("1 - Submit account request");
                System.out.println("2 - Deposit");
                System.out.println("3 - Withdraw");
                int bankChoice = sc.nextInt();
                sc.nextLine();

                if (bankChoice == 1) {
                    System.out.print("Enter account number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();
                    sc.nextLine();

                    requestQueue.offer(new AccountRequest(accNum, username, bal));
                    System.out.println("Account request submitted.");
                } else if (bankChoice == 2) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    for (BankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(user)) {
                            acc.deposit(amount);
                            history.push("Deposit " + amount + " to " + user);
                            System.out.println("New balance: " + acc.balance);
                        }
                    }
                } else if (bankChoice == 3) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    for (BankAccount acc : accounts) {
                        if (acc.username.equalsIgnoreCase(user)) {
                            if (acc.withdraw(amount)) {
                                history.push("Withdraw " + amount + " from " + user);
                                System.out.println("New balance: " + acc.balance);
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                        }
                    }
                }

            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String user = sc.nextLine();

                for (BankAccount acc : accounts) {
                    if (acc.username.equalsIgnoreCase(user)) {
                        System.out.println("Balance: " + acc.balance);
                    }
                }

            } else if (choice == 3) {
                System.out.println("\nADMIN AREA");
                System.out.println("1 - Process account request");
                System.out.println("2 - Add bill");
                System.out.println("3 - Process next bill");
                int adminChoice = sc.nextInt();
                sc.nextLine();

                if (adminChoice == 1) {
                    AccountRequest req = requestQueue.poll();
                    if (req != null) {
                        accounts.add(new BankAccount(req.accountNumber, req.username, req.balance));
                        System.out.println("Processed request for: " + req.username);
                    } else {
                        System.out.println("No pending requests.");
                    }
                } else if (adminChoice == 2) {
                    System.out.print("Enter bill name: ");
                    String bill = sc.nextLine();
                    billQueue.offer(bill);
                    System.out.println("Bill added.");
                } else if (adminChoice == 3) {
                    String bill = billQueue.poll();
                    if (bill != null) {
                        System.out.println("Processing: " + bill);
                    } else {
                        System.out.println("No bills in queue.");
                    }
                }
            }

        } while (choice != 4);

        System.out.println("Program ended.");
    }
}
