package SpotifyUsers;

import SpotifyItems.PlayableItem;
import utils.EmptyPlayListException;
import utils.ItemAlreadyExistsException;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountFree extends Account{
    private int frequencyOfAdvertisements;
    public AccountFree(String name, String surname, Date birthday, String code){
       super( name,  surname,  birthday,  code);
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
        int option = new Scanner(System.in).nextInt();

        switch (option){
            case 1:
                //aggiungere dati sul brano/podcast -- da implementare
                //non sarebbe meglio costruire il l'oggetto brano solo con  l'ID univoca e poi settare gli attributi?
               try{
                String playableItemId = new Scanner(System.in).nextLine();
                String title = new Scanner(System.in).nextLine();
                int timeLenght = new Scanner(System.in).nextInt();
                String artist = new Scanner(System.in).nextLine();
                int publicationYear = new Scanner(System.in).nextInt() - 1900;
                int publicationDay = new Scanner(System.in).nextInt();
                int publicationMonth = new Scanner(System.in).nextInt();
                PlayableItem brano = new PlayableItem(playableItemId, title,timeLenght,artist,publicationYear, publicationDay, publicationMonth, "traccia.mp4");
                this.getPlaylist().add(brano);} catch (InputMismatchException e){
                System.out.println("Please enter a valid option!");

            }
            case 2:
                //inserire brani per la rimozione -- da implementare come metodo ulteriore di Account Free
                // che chiede tutte le informazioni del caso per poter popolare tutte le informazioni richieste dal costruttore di Podcast e Music
            case 3: // perché mi lancia anche questa eccezione????
                try{
                getPlaylist().play();} catch (EmptyPlayListException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                 System.out.println("Goodbye" + " " + getName()+ "!");
                 return;

            default:
             System.out.println("Please enter a valid option!");
        }}


    }


}
