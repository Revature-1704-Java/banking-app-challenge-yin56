package com.revature.account;

import java.io.Serializable;

import com.revature.account.Account;

public class CheckingAccount extends Account{
    private static final long serialVersionUID = 1L;
    //private double balance = 0.0;

    public CheckingAccount(){

    }


    public void printBalance(){
        System.out.println("Your current checking balance: $" + this.getBalance());
    }
}