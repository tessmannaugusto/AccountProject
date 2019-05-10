package Services;

import Entities.Account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AccountBasics {

    private Account account;
    private String path;


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
}
