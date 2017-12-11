package com.revature.app;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
import com.revature.account.*;
import java.io.*;


public class App 
{
    public static void main( String[] args )
    {
        //1. Ask user for account information(username or password)
        //2. If no account, ask to create a new account
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!");
        
       
        while(true){
            System.out.println("What would you like to do? Type in number.");
            System.out.println("1.Access existing account\t2.Create a new account\t3.Exit");
            String opt = sc.nextLine();
            if(opt.equals("1")){
                accessAccount();
            }
            else if(opt.equals("2")){
                createAccount();
            }
            else if(opt.equals("3")){
                System.out.println("Goodbye");
                break;
            } 
            else{
                System.out.println("Not an option. Try again.");
            }
        }
        

    }


    //save information to file
    public static void createAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your first name: ");
        String fname = sc.nextLine();
        System.out.print("Please enter your last name: ");
        String lname = sc.nextLine();
        System.out.print("Please enter a username: ");
        String username = sc.nextLine();
        System.out.print("Please enter a password: ");
        String password = sc.nextLine();
        BankAccount a = new BankAccount(username, password, fname, lname);
        
        boolean s = saveAccount(a);
        if(s == true){
            System.out.println("Thank you for creating an account!\n");
        }
        else{
            System.out.println("Something went wrong with creating your account. Please try again.\n");
        }
    }

    //access information from file
    public static void accessAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your username: ");
        String username = sc.nextLine();
        System.out.print("Please enter a password: ");
        String password = sc.nextLine();

        //System.out.print("Retrieving!");
        BankAccount a = getAccount(username, password);
        //System.out.println(a);
        if(a == null){
            return;
        }
        System.out.println("Hi! " + a.getFirstName());
        System.out.println("Your current checking balance: " + a.getCheckingBalance());
        System.out.println("Your current saving balance: " + a.getSavingBalance());
        //in account loop
        while(true){
            
            System.out.println("What would you like to do?");
            System.out.println("1.Deposit\t2.Withdraw\t3.Transfer Saving to Checking\t4.Transfer Checking to Saving\t5.Logout");

            String option = sc.nextLine();

            System.out.println("\n");
            if(option.equals("1")){
                System.out.println("How much do you want to deposit?");
                String amt = sc.nextLine();
                Double d = Math.round(Double.parseDouble(amt) * 100.0)/100.0;
                a.deposit(d);
                saveAccount(a);
            }
            else if(option.equals("2")){
                System.out.println("How much do you want to withdraw?");
                String amt = sc.nextLine();
                Double d = Math.round(Double.parseDouble(amt) * 100.0)/100.0;
                a.withdraw(d);
                saveAccount(a);
            }
            else if(option.equals("3")){
                System.out.println("How much do you want to transfer?");
                String amt = sc.nextLine();
                Double d = Math.round(Double.parseDouble(amt) * 100.0)/100.0;
                a.transferToChecking(d);
                saveAccount(a);
            }
            else if(option.equals("4")){
                System.out.println("How much do you want to transfer?");
                String amt = sc.nextLine();
                Double d = Math.round(Double.parseDouble(amt) * 100.0)/100.0;
                a.transferToSaving(d);
                saveAccount(a);
            }
            else if(option.equals("5")){
                saveAccount(a);
                System.out.println("Goodbye!");
                break;
            } 
            else{
                System.out.println("Not an option. Try again.");
            }
            
        }
        

    }

    public static boolean saveAccount(BankAccount a){
        String filename = a.getUsername();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(a);
		} catch(IOException ex){
            ex.printStackTrace();
            return false;
            //
        }
        return true;
    }

    public static BankAccount getAccount(String username, String password){
        String filename = username;
        BankAccount obj = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            obj = (BankAccount)ois.readObject();
            if(obj.getPassword().equals(password)){
                System.out.println("Login successful.\n");
                return obj;
            }
            else{
                System.out.println("Invalid Password. Please Try again.\n");
            }
            
		} catch(FileNotFoundException ex){
            //ex.printStackTrace();
            System.out.println("Account does not exist. Please try again.\n");
            return null;
		} catch(IOException ex){
			ex.printStackTrace();
		} catch(ClassNotFoundException ex){
			ex.printStackTrace();
        }
        
        return null;
    } 
}
