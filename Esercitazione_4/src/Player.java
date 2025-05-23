import java.util.Scanner;

public class Player {
    private String name;
    private int numVictories;
    private int numLosses;

    public Player(String name){
        this.name = name;
        this.numLosses = 0;
        this.numVictories= 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumLosses(int numLosses) {
        this.numLosses = numLosses;
    }

    public void setNumVictories(int numVictories) {
        this.numVictories = numVictories;
    }

    public String getName() {
        return name;
    }

    public int getNumLosses() {
        return numLosses;
    }

    public int getNumVictories() {
        return numVictories;
    }

    public int[] pickMove(){
        int[] mossa = new int[2];
        Scanner input = new Scanner(System.in);
        System.out.println("Selezionare una mossa ammissibile");
        System.out.println("Inserire riga: ");
        mossa[0] = input.nextInt() - 1; //indicizzazione degli array di java
        System.out.println("Inserire colonna: ");
        mossa[1] = input.nextInt() - 1; //indicizzazione degli array di java
        return mossa;




    }
}
