
package com.mycompany.bankingapp;

// used to create an account
public class BankAccount {
    private String name;
    private String password;
    // String accountType;
    private int accountNum;
    
    
    BankAccount(){
        this.name = "name";
        this.password = "password";
        this.accountNum = 1;
    }
    BankAccount(String inName, String inPassword, int inAccountNum){
        this.name = inName;
        this.password = inPassword;
        this.accountNum = inAccountNum;
    }
    
    
    // METHODS
    public String toString(){
        String r = "Name: \t\t\t" + this.name + 
                "\nPassword: \t\t" + this.password + 
                "\nAccount number: \t" + this.accountNum;
        return r;
    }
    
    
    // getters
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public int getAccountNum(){
        return this.accountNum; 
    }
    
    
    // setters
//    public void setName(String name){
//        this.name = name; 
//    }
    
    
}
