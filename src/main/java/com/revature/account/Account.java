package com.revature.account;

import java.io.Serializable;

public abstract class Account implements Serializable{

    protected double balance = 0.0;
    private static final long serialVersionUID = 1L;

    public Account(){

    }


    public abstract void printBalance();

    public double getBalance(){
        return this.balance;
    }

    public void setBalance(double amount){
        this.balance = amount;
    }

    
}