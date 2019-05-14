package Services;

import Entities.Account;

import java.io.*;
import java.util.Objects;

public class AccountBasics {

    private Account account;
    private String path;


    public AccountBasics(Account account, String path) {
        this.account = account;
        this.path = path;
    }

    public void writeAccount(Account account ){
        try(BufferedWriter bw= new BufferedWriter(new FileWriter(path,true))){
            bw.newLine();
            bw.write(account.getName() + "," + account.getEmail() + "," + account.getLogin() + "," + account.getPassword());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void searchAccountData(Account account){
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String itemCsv = br.readLine();
            boolean isAccepted = false;
            while(itemCsv != null ){
                String[] login = itemCsv.split(",");
                if (account.getLogin().equals(login[2]) && account.getPassword().equals(login[3])) {
                    isAccepted = true;
                    System.out.println(isAccepted);
                    System.out.println("Login successful.");
                    break;
                }else{
                    itemCsv = br.readLine();
                }
            }
            if (isAccepted == false) {
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
