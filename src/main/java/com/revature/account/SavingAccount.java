package com.revature.account;

import java.io.Serializable;

import com.revature.account.Account;

public class SavingAccount extends Account{
    private static final long serialVersionUID = 1L;
    //private double balance = 0.0;

    public SavingAccount(){

    }

    public void printBalance(){
        System.out.println("Your current saving balance: " + this.getBalance());
    }
}
