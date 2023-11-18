
package com.mycompany.bankingapp;

import java.util.Scanner; 

public class Main {
    public static void main(String args[]){
        Scanner userIn = new Scanner(System.in);
        Accounts accounts = new Accounts();
        // ==================================

        // START
        // MAIN LOOP
        boolean userLeft = false;
        do{
            System.out.println("\nBANKING APP");
            System.out.println("===========");
        
            // login, or sign up
            accounts.select();

            // rerun
            System.out.print("\nRerun? (y/n) ");
            String rerun = userIn.next();
            
            if (rerun.equals("n")){
                userLeft = true; 
                System.out.print("<User closed the program>\n");
            }
        }
        while(!userLeft);
       
        
//        BankApp obj = new BankApp();
//        obj.mainMenu();
//               

        // END
        System.out.println("\nEND OF PROGRAM");
    }
}
