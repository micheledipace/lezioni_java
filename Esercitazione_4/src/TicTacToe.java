import java.util.Scanner;

public class TicTacToe {
    private Player player;
    private Computer computer;
    private Board board;

    //possimao chiedere il nome dell'utente
    public TicTacToe(){
       Scanner input = new Scanner(System.in);
       System.out.println("Inserisci il nome del giocatore: ");
      this.player = new Player(input.nextLine());

        System.out.println("Inserisci la difficoltà desiderata: ");
        int difficulty = input.nextInt();
        computer = new Computer(difficulty);

    }

    public void menu(){
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("Menu TicTacToe \n");
            System.out.println("1. Avvia partita \n");
            System.out.println("2. Mostra statistiche \n");
            System.out.println("3. Esci\n");
            int option=input.nextInt();
            switch(option){
                case 1 -> game();
                case 2 -> showStats();
                case 3 -> {return;}
            }
        }
    }

    public void game(){
       Board board  = new Board();
       int[] move;
       while (board.checkAvailableMoves() != 0 && board.checkStatus() == 0){ // posso non avere più mosse disponibili e non avere un esito
           System.out.println(board);
          move = player.pickMove();
          board.makeMove(move[0], move[1], true, false);
          move = computer.pickBestMove(board);
          board.makeMove(move[0], move[1], false, false);
       }
       int status = board.checkStatus();
       board.printStatus(status);
    }

    public void showStats(){

    }
}
