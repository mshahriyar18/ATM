/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author m_f_s
 */
public class Account {

              // 03/26/2019 - Mustafa Shahriyar - attributes

              private int acctNumber;

              private String name;

              private double balance;

              // 03/26/2019 - Mustafa Shahriyar - constructor to initialize all fields

              public Account(int acctNumber, String name, double balance) {

                           this.acctNumber = acctNumber;

                           this.name = name;

                           this.balance = balance;

              }

              @Override

              public String toString() {

                           return acctNumber + ":" + name + ":" + balance;

              }

              // 03/26/2019 - Juan De La Cruz - method to deposit money

              public void deposit(double amount) {

                           if (amount >= 0) {

                                         // 03/26/2019 - Juan De La Cruz - valid amount

                                         balance += amount;

                           }

              }
             
              // 03/27/2019 - Juan De La Cruz - method to withdraw money

              public void withdraw(double amount) {

                           if (amount >= 0 && amount <= balance) {

                                         //03/26/2019 - Juan De La Cruz - valid amount, enough balance

                                         balance -= amount;

                           }

              }
              // 03/27/2019 - Juan De La Cruz - returns balance 
              public double getBalance() {

                           return balance;

              }
              // 03/27/2019 - Juan De La Cruz - Sets the balance from the data file
              public void setBalance(double balance) {

                           this.balance = balance;

              }
              //03/27/2019 - Juan De La Cruz - returns customer's name
              public String getName() {

                           return name;

              }
              // 03/27/2019 - Juan De La Cruz - returns the account number
              public int getAcctNumber() {

                           return acctNumber;

              }

}