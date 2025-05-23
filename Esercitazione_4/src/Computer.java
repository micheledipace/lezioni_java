public class Computer {
    private int difficulty = 100;

    public Computer(int difficulty) {
        this.difficulty = difficulty;
    }

    public int minMax(Board board, boolean max, int currentDepth) {
        //la prima cosa da fare è implementare la stopping condition, altrimenti potremmo avere problemi nell'implementare la restante parte dell'algoritmo ricorsivo
        //aumenteremo di volta in volta la profondità corrente fino a raggiungere la difficoltà
        //controllando lo stato otterrò l'utilità per l'utente e per il computer
        //la seconda condizione di arresto è la vittoria del giocatore o del computer
        // la terza condizione di arresto è quando non ci sono più mosse disponibili : la partita è finita in pareggio
        if (currentDepth == difficulty || board.checkStatus() != 0 || board.checkAvailableMoves() == 0) {
            return board.checkStatus();
        }
        int status = 0;
        //ricorsioni alternative
        //il computer dovrà scegliere la mossa con utilità massima, scartando le altre
        //dobbiamo effettuare un controllo per verificare che utilità ha una mossa
        if (max) {
            status = -100; // il "maximizer" cercherà di aggiornare l'esito al valore più grande possibile
            for (int i = 0; i < board.getBOARD_WIDTH(); i++) {
                for (int j = 0; j < board.getBOARD_WIDTH(); j++ ) {
                    if (board.makeMove(i, j, false, false)) {
                        int tmp = minMax(board, false, currentDepth + 1); //dobbiamo calcolare se l'esito è minore o maggiore di quello di partenza
                        if (tmp >= status) {
                            status = tmp;
                        }
                        board.makeMove(i, j, false, true);
                    }
                }

            }
        }


        //nell'algoritmo "minimizer" il computer indosserà le vesti del giocatore
        else {
            status = -100;
            for (int i = 0; i < board.getBOARD_WIDTH(); i++ ) {
                for (int j = 0; j < board.getBOARD_WIDTH(); j++ ) {
                    if (board.makeMove(i, j, true, false)) {
                        int tmp = minMax(board, true, currentDepth + 1);
                        if (tmp <= status) {
                            status = tmp;
                        }
                        board.makeMove(i, j, false, true);
                    }
                }

            }

        }

        //restituire il valore di utilità
        return status;
    }

    // i due cicli for indentificano tutte le mosse possibili
    // a parità di esito sceglierà la prima mossa
    //all'aumentare della difficoltà le scelte perse saranno quasi sempre le più efficaci
    public int[] pickBestMove(Board board) {


        int[] bestMove = new int[2];
        int status = -100;

        for (int i = 0; i < board.getBOARD_WIDTH(); i++  ) {
            for (int j = 0; j < board.getBOARD_WIDTH(); j++) {
                if(board.makeMove(i,j,false,false)){
                    int tmp = minMax(board, false, 0); // la profondità è importante in un gioco come gli scacchi, in quanto la partita può raggiungere stati indeterminati (stallo)
                    if (tmp > status){
                       status = tmp;
                       bestMove[0] = i;
                       bestMove[1] = j;
                    }
                   board.makeMove(i,j,false,true);
                }
            }
        }
        return bestMove;
    }
}
