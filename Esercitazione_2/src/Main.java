import SpotifyItems.PlayList;
import SpotifyUsers.Account;
import SpotifyUsers.AccountFree;
import SpotifyUsers.Person;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        AccountFree myAccount = new AccountFree("Michele", "Dipace", new Date(2005,5,25) , "1234");
        myAccount.setEmail("pippo1234@gmail.com");
        myAccount.setPassword("pippo1234");
        myAccount.menuAccount();


    }
}
