package com.revature.account;

import java.io.Serializable;

public class BankAccount implements Serializable{
    private CheckingAccount checking = new CheckingAccount();
    private SavingAccount saving = new SavingAccount();

    private String username;
    private String password;
    private String ownerFirstName;
    private String ownerLastName;
    //private double balance = 0.0;
    private static final long serialVersionUID = 1L;

    public BankAccount(String username, String password, String ownerFirstName, String ownerLastName){
        this.username = username;
        this.password = password;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
    }

    public BankAccount(){
        
    }

    @Override
	public String toString(){
		return "Account [" + ownerFirstName + ", " + password + "]";
	}


    public void withdraw(double amount){
        if(amount > checking.getBalance()){
            System.out.println("You don't have enough to withdraw");
        }
        else{
            double b = checking.getBalance();
            b = b - amount;
            checking.setBalance(b);
            checking.printBalance();
        }
    }

    public void deposit(double amount){
        double balance = checking.getBalance();
        balance = balance + amount;
        checking.setBalance(balance);
        checking.printBalance();
    }

    public void transferToSaving(double amount){
        if(amount > checking.getBalance()){
            System.out.println("You don't have enough to transfer to Saving");
        }
        else{
            double b = checking.getBalance();
            b = b - amount;
            checking.setBalance(b);

            double t = saving.getBalance();
            t = t + amount;
            saving.setBalance(t);
            
            checking.printBalance();
            saving.printBalance();
        }
    }

    public void transferToChecking(double amount){
        if(amount > saving.getBalance()){
            System.out.println("You don't have enough to transfer to Checking");
        }
        else{
            double b = saving.getBalance();
            b = b - amount;
            saving.setBalance(b);

            double t = checking.getBalance();
            t = t + amount;
            checking.setBalance(t);
            
            checking.printBalance();
            saving.printBalance();
        }
    }

    public double getCheckingBalance(){
        return checking.getBalance();
    }

    public double getSavingBalance(){
        return saving.getBalance();
    }

    public String getFirstName(){
        return this.ownerFirstName;
    }

    public String getLastName(){
        return this.ownerLastName;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}