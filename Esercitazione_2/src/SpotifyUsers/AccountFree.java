package SpotifyUsers;

import utils.EmptyPlayListException;

import java.util.Scanner;

public class AccountFree extends Account{
    private int frequencyOfAdvertisements;
    public AccountFree(){
       super();
       frequencyOfAdvertisements = 3; // ci dovranno essere al massimo un numero di pubblicitá pari a 3

    }

    public int getFrequencyOfAdvertisements() {
        return frequencyOfAdvertisements;
    }

    public void setNumberOfAdvertisements(int frequencyOfAdvertisements) {
        this.frequencyOfAdvertisements = frequencyOfAdvertisements;
    }

    // dopo aver loggato dobbiamo fare in modo di poter utilizzare la nostra applicazione
    // implementiamo un menú per l'account free
   // aggiungere, rimuovere e riprodurre un brano dalla playlist
    @Override
    public void menuAccount(){
        System.out.println("Welcome to Spotify " + getName());
        while (true){
       System.out.println("Select an option from the following ones:");
       System.out.println("1. Add an Item to your Playlist");
        System.out.println("2. Remove an Item for you Playlist");
        System.out.println("3. Play an Item in your playlist");
        System.out.println("4. Logout");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option){
            case 1:
                //aggiungere dati sul brano/podcast -- da implementare
            case 2:
                //inserire brani per la rimozione -- da implementare come metodo ulteriore di Account Free
                // che chiede tutte le informazioni del caso per poter popolare tutte le informazioni richieste dal costruttore di Podcast e Music
            case 3:
                try{
                getPlaylist().play();} catch (EmptyPlayListException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                System.out.println("Goodbye!");
                return;
        }}


    }


}
