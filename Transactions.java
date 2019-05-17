/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author m_f_s
 */
public class Transactions
{
    public static void showBalance(Account acct) {
                        //03/28/2019 - Mustafa Shahriyar - Shows the current balance
                           System.out.printf("Your current balance is $%.2f\n", acct.getBalance());

              }
    
     public static void doDeposit(Account acct, String s) {
                        // 03/28/2019 - Mustafa Shahriyar - method for deposit
                           try {

                                         double amount = Double.parseDouble(s);

                                         if (amount >= 0) {

                                                       acct.deposit(amount);

                                                       showBalance(acct);

                                         } else {

                                                       System.out.println("You cannot deposit a negative amount.");

                                         }
                        // 03/28/2019 - Mustafa Shahriyar - adding exception
                           } catch (Exception e) {

                                         System.out.println(s + " is not an number.");

                           }

              }
     
                        // 03/28/2019 - Juan De La Cruz - withdrawal option
       public static void doWithdrawal(Account acct, String s) {

                           try {

                                         double amount = Double.parseDouble(s);

                                         if (amount >= 0) {

                                                       if (acct.getBalance() >= amount) {

                                                                    // 03/28/2019 - Juan De La Cruz - valid, withdrawing amount

                                                                    acct.withdraw(amount);

                                                                    // 03/28/2019 - Juan De La Cruz - displaying balance

                                                                    showBalance(acct);
                                                                    // 03/28/2019 - Juan De La Cruz - verifying logical withdrawal
                                                       } else {

                                                                    System.out.println("You cannot withdraw more than you have.");

                                                       }

                                         } else {

                                                       System.out.println("You cannot withdraw a negative amount.");

                                         }

                           } catch (NumberFormatException e) {

                                         // 03/28/2019 - Juan De La Cruz - non numeric input

                                         System.out.println(s + " is not a number");

                           }

              }
       
           public static ArrayList<Account> readAccounts(Scanner fileInput) {

                           // 03/28/2019 - Juan De La Cruz - creating empty array list

                           ArrayList<Account> accountList = new ArrayList<Account>();

                           // 03/28/2019 - Juan De La Cruz - looping until end of file

                            while (fileInput.hasNext()) {

                                         // 03/28/2019 - Juan De La Cruz - fetching line

                                         String line = fileInput.nextLine().trim();

                                         // 03/28/2019 - Juan De La Cruz - splitting line by :

                                         String fields[] = line.split(":");

                                         // 03/28/2019 - Juan De La Cruz - ensuring resultant array has 3 elements

                                         if (fields.length == 3) {

                                                       // 03/28/2019 - Mustafa Shahriyar - trying to parse values and create an account

                                                       try {

                                                                    int accNum = Integer.parseInt(fields[0]);

                                                                    String name = fields[1];

                                                                    double balance = Double.parseDouble(fields[2]);

                                                                    // 03/28/2019 - Mustafa Shahriyar- creating an Account and adding to list

                                                                    Account account = new Account(accNum, name, balance);

                                                                    accountList.add(account);

                                                       } catch (NumberFormatException e) {

                                                                    System.out.println("Bad input format found in accounts.dat!");

                                                                    // 03/28/2019 - Mustafa Shahriyar - bad format, returning an empty array list

                                                                    return new ArrayList<Account>();

                                                       }

                                         }

                           }

                           return accountList;

              }

              public static void writeAccounts(ArrayList<Account> accounttList) {

                           try {

                                         // 03/29/2019 - Mustafa Shahriyar - opening PrintWriter

                                         PrintWriter writer = new PrintWriter(new File("accounts.dat"));

                                         // 03/29/2019 - Mustafa Shahriyar - writing all Account objects' toString() value to the file

                                         for (Account acc : accounttList) {

                                                       writer.println(acc.toString());

                                         }

                                         writer.close();

                           } catch (FileNotFoundException e) {

                                         // 03/29/2019 - Mustafa Shahriyar - file error

                                         System.out.println(e.getMessage());

                           }

              }
              
                public static int findIndex(ArrayList<Account> accountList,

                                         int accountNumber) {

                           for (int i = 0; i < accountList.size(); i++) {

                                         if (accountList.get(i).getAcctNumber() == accountNumber) {

                                                       // 03/29/2019 - Mustafa Shahriyar - found the desired account number

                                                       return i;

                                         }

                           }

                           // 03/29/2019 - Mustafa Shahriyar - when account number is not found

                           return -1;

              }

              public static int getAccountIndex(ArrayList<Account> accountList, String s) {

                           try {

                                         int accountNum = Integer.parseInt(s);

                                         // 03/29/2019 - Mustafa Shahriyar- valid integer, finding index

                                         int index = findIndex(accountList, accountNum);

                                         if (index == -1) {

                                                       // 03/29/2019 - Mustafa Shahriyar - unknown account

                                                       System.out.println("Unknown account number.");

                                         }

                                         return index;

                           } catch (NumberFormatException e) {

                                         // 03/29/2019 - Mustafa Shahriyar - non numeric input

                                         System.out.println(s + " is not a number.");

                           }

                           return -1;

              }

              public static void doTransactions(Account acct, Scanner input) {

                           String choice = "";

                           // 03/29/2019 - Mustafa Shahriyar - looping until user types F or f

                           while (!choice.equalsIgnoreCase("F")) {

                                         System.out.print("Please select a choice to: (D) Deposit, (W) Withdraw, or (F) Finish? ");

                                         choice = input.nextLine();

                                         if (choice.equalsIgnoreCase("D")) {

                                                       System.out.print("Please enter amount to deposit: $");

                                                       doDeposit(acct, input.nextLine());

                                         } else if (choice.equalsIgnoreCase("W")) {

                                                       System.out.print("Please enter amount to withdraw: $");

                                                      doWithdrawal(acct, input.nextLine());

                                         } else if (!choice.equalsIgnoreCase("F")) {

                                                       System.out.println("Invalid choice.");

                                         }

                           }

              }


    
}
  