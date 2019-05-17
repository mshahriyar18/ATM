/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Scanner;

public class Customer {

    public static void main(String[] args) {
        
                           Transactions first = new Transactions(); // 04/04/2019 - Mustafa Shahriyar - Instantiating Transaction class
                           
                           Scanner fileScanner = null;
                           // 04/04/2019 - Mustafa Shahriyar - Will search for the accounts from the text file
                           try {

                                         fileScanner = new Scanner(new File("accounts.dat"));

                           } catch (FileNotFoundException e) {

                                         //04/04/2019 - Mustafa Shahriyar - file not opened

                                         System.out.println("accounts.dat file not found!");

                                         System.exit(0);

                           }

                           // 04/05/2019 - Juan De La Cruz - reading accounts list from file

                           ArrayList<Account> accountsList = first.readAccounts(fileScanner);

                           if (accountsList.size() > 0) {

                                         // 04/05/2019 - Juan De La Cruz - atleast one account info is read

                                         // 04/05/2019 - Juan De La Cruz - creating Scanner

                                         Scanner keyboard = new Scanner(System.in);

                                         // 04/05/2019 - Juan De La Cruz - looping infinitely

                                         while (true) {

                                                       // 04/05/2019 - Juan De La Cruz - reading account number

                                                       System.out.print("To access your account, please enter your account number: ");

                                                       String accountNum = keyboard.nextLine();

                                                       if (accountNum.equals("")) {

                                                                    // 04/05/2019 - Juan De La Cruz - end of loop

                                                                    break;

                                                       }

                                                       // 04/07/2019 - Mustafa Shahriyar - finding index of account

                                                       int index = first.getAccountIndex(accountsList, accountNum);

                                                       if (index != -1) {

                                                                    //04/05/2019 - Mustafa Shahriyar - finding index of accountaccount exist

                                                                    Account account = accountsList.get(index);

                                                                    // 04/05/2019 - Mustafa Shahriyar - displaying a greeting message

                                                                    System.out.println("Welcome, " + account.getName() + "!");

                                                                    // 04/05/2019 - Mustafa Shahriyar - showing balance

                                                                    first.showBalance(account);

                                                                    // 04/05/2019 - Mustafa Shahriyar - doing transactions

                                                                    first.doTransactions(account, keyboard);

                                                                    // 04/05/2019 - Mustafa Shahriyar - saving updated info

                                                                    first.writeAccounts(accountsList);
                                                                    
                                                                    // 04/05/2019 - Mustafa Shahriyar - Ends with the current account number

                                                                     System.out.println("Goodbye, " + account.getName() + "!");

                                                       }

                                         }

                                         System.out.println("Bank program concludes.");

                           }

              }

}