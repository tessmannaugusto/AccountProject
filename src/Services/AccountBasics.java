package Services;

import Entities.Account;

import java.io.*;
import java.util.Objects;

public class AccountBasics {

    private Account account;
    private String path;

// fazer account superclass para poder instanciar as duas diferentes.
    public AccountBasics(Account account, String path) {
        this.account = account;
        this.path = path;
    }

    public void writeAccount(Account account ){
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(path,true))){
            bw.write(account.getName() + "," + account.getEmail() + "," + account.getLogin() + "," + account.getPassword());
            bw.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void searchAccountData(Account account){
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String[] login = br.readLine().split(",");
            while(!account.getLogin().equals(login[2])){
                login = br.readLine().split(",");
            }
            if (account.getLogin().equals(login[2])){
                Boolean test = account.getPassword().equals(login[3]);
                if (test == true){
                    System.out.println("Login successful.");
                }
            }else{
                System.out.println("Wrong login or password.");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBasics that = (AccountBasics) o;
        return Objects.equals(account, that.account) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, path);
    }
}
