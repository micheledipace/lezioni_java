package SpotifyUsers;

import SpotifyItems.PlayList;
import SpotifyItems.PlayableItem;
import utils.AccountType;

public class Account extends Person{
    private String email;
    private String password;
    private AccountType accountType;
    private PlayList<PlayableItem> playlist; // elemento principale sia per gli account premium che per gli account free

    public Account(){
        super();
        email = "Default email";
        password = "Default password";
        accountType = AccountType.FREE;
        playlist = new PlayList<>();
    }
    //getters


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public PlayList<PlayableItem> getPlaylist() {
        return playlist;
    }

    // setters


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void menuAccount(){
        return;
    }
}

