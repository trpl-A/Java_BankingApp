package com.mycompany.bankingapp;

import java.util.Scanner;
import java.util.Arrays;

public class BankApp {

    private Scanner userIn = new Scanner(System.in);

    private double balance;
    private double deposit;
    private double withdraw;

    BankApp() {
        this.balance = 91_000.50;
        this.deposit = 1201.50;
        this.withdraw = 1000.10;
    }

    BankApp(double inBalance, double inDeposit, double inWithdraw) {
        this.balance = inBalance;
        this.deposit = inDeposit;
        this.withdraw = inWithdraw;
    }

    // METHODS
    // getters
    public Scanner getUserIn() {
        return userIn;
    }

    public double getBalance() {
        return balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }
    // -------------------------------------  

    // setters 
    public void setUserIn(Scanner userIn) {
        this.userIn = userIn;
    }

    public void setBalance(double extra) {
        this.balance += extra;
    }

    public void setDeposit(double deposit) {
        this.deposit += deposit;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw += withdraw;
    }
    // -------------------------------------  

    // array of options
    // Main
    public String mainMenu(String username, String password) {
        // heading
        System.out.println("Main Menu\n");

        String option = "";
        System.out.println("1) View account info");
        System.out.println("2) Deposit money");
        System.out.println("3) Withdraw money");
        System.out.println("4) Search by name");
        System.out.println("5) Search by account number");
        System.out.println("6) Close");

        // main loop
        boolean usingMainMenu = true;
        while (usingMainMenu) {
            System.out.print("> ");
            option = getUserIn().next();

            // from accounts class
            Accounts acc = new Accounts();

            switch (option) {
                default -> System.out.println("*incorrect input*\n");

                case "1" -> accountInfo(username, password);
                case "2" -> deposit();
                case "3" -> withdraw();
                case "4" -> acc.searchName();
                case "5" -> acc.searchAccNum();
                case "6", "exit" -> {
                    System.out.println("closing...");
                    System.exit(0);
                }
            }
        }

        return option;
    }

    // ===============================================
    // option1
    public void accountInfo(String inUsername, String inPassword) {
        // heading
        System.out.println("Account info\n");

        System.out.println("Username: \t\t" + inUsername);
        System.out.println("Password: \t" + inPassword);
        // System.out.println("Account number: \t" + accNum);

        System.out.println("\nCurrent balance: \tR" + this.balance);
        System.out.println("Total money deposited: \tR" + this.deposit);
        System.out.println("Total money withdrawn: \tR" + this.withdraw);

        // end-line
        System.out.println("------------------\n");
    }

    // ===============================================
    // option2
    public void deposit() {
        // heading
        System.out.println("Deposit\n");

        System.out.print("Enter an amount to deposit: ");
        String depositStr = userIn.next();
        try {
            double depositAmount = Double.valueOf(depositStr);
            // updating info
            setDeposit(depositAmount);
            setBalance(depositAmount);
            
            // displaying
            System.out.println("\n*Transfer complete*");
            System.out.println("Deposited R" + depositAmount);
            System.out.println("New balance: R" + balance);

            // end-line
            System.out.println("------------------\n");
        } 
        
        catch (Exception e) {
            System.out.println("*invalid input*\n");
        }

    }

    // ===============================================
    // option3
    public void withdraw() {
        // heading
        System.out.println("Withdraw\n");

        System.out.print("Enter an amount to withdraw: ");
        String withdrawStr = userIn.next();

        try {
            Double withdrawAmount = Double.valueOf(withdrawStr);
            if (withdrawAmount > this.balance) {
                System.out.println("You don't have enough money\n");
            } 
            
            else {
                setWithdraw(withdrawAmount);

                System.out.println("\n*Transfer complete*");
                System.out.println("Withdrew R" + withdrawAmount);
                balance -= withdrawAmount;
                System.out.println("New balance: R" + balance);

                // end-line
                System.out.println("------------------\n");
            }

        } 
        catch (Exception e) {
            System.out.println("*invalid input*\n");
        }
    }
    // ===============================================
    // option4 -> in Accounts class
    // option5 -> in Accounts class

}
