package com.mycompany.bankingapp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Accounts {

    Scanner userIn = new Scanner(System.in);

    private int numOfAccounts;
    private BankAccount[] bankAccounts = new BankAccount[7];
    private String password;
    private String passwordReenter;

    Accounts() {
        numOfAccounts = 4;
        bankAccounts[0] = new BankAccount();
        bankAccounts[1] = new BankAccount("James", "batty", 11);
        bankAccounts[2] = new BankAccount("Selena", "s3l3nA", 19);
        bankAccounts[3] = new BankAccount("Hans", "ch3$s.com", 20);
    }

    // METHODS
    // getters
    public BankAccount[] getAccounts() {
        return this.bankAccounts;
    }

    // -------------------------------
    // option4 (other class)
    public void searchName() {
        // heading
        System.out.print("Search (by name)\n");

        System.out.print("Enter a name to search for: ");
        String searchName = userIn.nextLine();

        for (BankAccount account : bankAccounts) {
            if (account != null) {
//                    System.out.println(account.getName());

                if (searchName.equals(account.getName())) {
                    System.out.println(account);
                    System.out.println();
                } 

//                else if (!searchName.equals(account.getName()) && account == bankAccounts[bankAccounts.length - 1]){

                else if (!searchName.equals(account.getName()) && account == bankAccounts[bankAccounts.length - 1]){
                    System.out.println("Name not found\n");
                }
                
//                else {
//                    System.out.println("Name not found\n");
//                }
            }

        }
        // end-line
        System.out.println("------------------\n");
    }

    // ====================================
    // option5 (other class)
    public void searchAccNum() {
        // heading
        System.out.print("Search (by account number)\n");

        System.out.print("Enter an account number to search for: ");
        String searchAccNum = userIn.next();

        for (BankAccount account : bankAccounts) {
            if (account != null) {
                try {
                    int accNum = Integer.valueOf(searchAccNum);

                    if (accNum == account.getAccountNum()) {
                        System.out.println(account);
                        System.out.println();
                    } 
//                    else {
//                        System.out.println("Account number not found\n");
//                    }
                } 
                
                catch (Exception e) {
                    System.out.println("*invalid input*");
                }
            }

        }
        // end-line
        System.out.println("------------------\n");
    }
    // ====================================

    public void displayAllAccounts() {
        for (BankAccount a : bankAccounts) {
            System.out.println(a);
            System.out.println();
        }
    }
    // ====================================

    public boolean verfiyPassword(String password1, String password2) {
        boolean passwordsMatch = false;

        if (password.equals(password2)) {
            passwordsMatch = true;
        }

        return passwordsMatch;
    }

    public boolean verify(String name, String password) {
        boolean correctCredentials = false;

        for (BankAccount ba : bankAccounts) {
            if (ba != null) {
                    // account name and password
//                System.out.println(ba.getName());
//                System.out.println(ba.getPassword());
//                System.out.println("__________\n");

                if (name.equals(ba.getName()) && password.equals(ba.getPassword())) {
                    System.out.println("*Login Successful*\n");
                    correctCredentials = true;
                }
            }

        }
        return correctCredentials;
    }

    // ====================================
    // ====================================
    // 1, SIGN IN
    public void signIn() {
        System.out.print("Name: ");
        String signInName = userIn.next();

        System.out.print("Password: ");
        String signInPassword = userIn.next();

        boolean a = verify(signInName, signInPassword);
        // System.out.println(verify(signInName, signInPassword));

        if (a == true) {
            BankApp app = new BankApp();
            app.mainMenu(signInName, signInPassword);

            // get acc num instead?
//            app.mainMenu(signInName, accNum);

        } else {
            System.out.print("*invalid credentials*");
        }
    }

    // ====================================
    // 2, SIGN IN, creating an account
//    public BankAccount createAccount() {
    public void createAccount() {
        boolean correctPassword = false;

        // name
        System.out.print("Enter your name: ");
        String name = userIn.next();

        while (!correctPassword) {
            // password
            System.out.print("Enter your password: ");
            password = userIn.next();

            // password, re-enter
            System.out.print("Re-enter your password: ");
            passwordReenter = userIn.next();

            if (verfiyPassword(password, passwordReenter) == false) {
                System.out.println("*Passwords do not match*");
                System.out.println("\n*Enter a new password*");
            } 
            else {
                correctPassword = true;
            }
        }

        // id (auto)
        Random randInt = new Random();
        int randomInt = randInt.nextInt(1, 100);
        // System.out.println(randomInt);

        // creating user's account
        BankAccount newBankAccount = new BankAccount(name, password, randomInt);

        // displaying details
        System.out.println();
        System.out.println(newBankAccount);
        System.out.println("\n*Account created successfully*");

        // adding to the array
        bankAccounts[numOfAccounts] = newBankAccount;
        numOfAccounts += 1;
//        return newBankAccount;
    }
    // ====================================

    public String selectionMenu() {
        String option = "";

        System.out.println("1) Sign in");
        System.out.println("2) Sign up");

        while (!option.equals("1")
                && !option.equals("2")
                && !option.equals("accounts")) {
            System.out.print("> ");
            option = userIn.next();

            if (!option.equals("1")
                    && !option.equals("2")
                    && !option.equals("accounts")) {
                System.out.println("*incorrect input*\n");
            }
        }

        return option;
    }

    // MAIN
    public void select() {
        String s = selectionMenu();

        if (s.equals("1")) {
            System.out.println("\nSIGN IN");
            signIn();
        } else if (s.equals("2")) {
            System.out.println("\nSIGN UP");
            createAccount();
        } // hidden
        else if (s.equals("accounts")) {
            System.out.println("\n\nALL ACCOUNTS");
            displayAllAccounts();
        }
    }
}
