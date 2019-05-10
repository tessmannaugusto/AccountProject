package Application;

import Entities.Account;
import Services.AccountBasics;


import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Would you like to create a new account? (y/n) ");
        char r = scanner.next().charAt(0);
        if (r == 'y'){
            System.out.print("Enter name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter login: ");
            String login = scanner.nextLine();
            while (login.length() >= 10 || login.length() <=6){
                System.out.println("Login must have between 6 and 10 characters. Please try again.");
                System.out.print("Enter login: ");
                login = scanner.nextLine();
            }
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            Account account = new Account(name,email,login,password);
            AccountBasics ab = new AccountBasics(account,"C:\\temp\\out.txt");
            ab.writeAccount(account);
            System.out.println("Account created.");
        }
        System.out.println("Log in your account to access data.");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

    }
}
