public class Board {
    private final int BOARD_WIDTH = 3;
    int[][] board;

    // rappresentazioen da simbolo a numero
    // 0 : nessun simbolo, 1==X, -1==O
    public Board() {
        board = new int[BOARD_WIDTH][BOARD_WIDTH];
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) { //O(1) perchè BOARD_WIDTH è una costante
                board[i][j] = 0;
            }
        }
    }

    public int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    //makeMove può essere chiamata anche per svuotare una cella precedentemente riempita
    //bisogna gestire accuratamente l'input del giocatore per evitare OutOfBoundsExceptions
    public boolean makeMove(int row, int column, boolean player, boolean clean) {
        // verifichiamo che la posizione non sia già occupata
        if (clean) {
            board[row][column] = 0;
        }
        else {
            //scegliamo che sia il giocatore ad iniziare per primo

            if (board[row][column] != 0) {
                return false; //il return rende inutile un qualsiasi blocco else
            }
            if (player) {
                board[row][column] = 1;
            }else {
                board[row][column] = -1;
            }
        }
        return true;
    }


    private int evaluateStatus(int sumMove) {
        switch (sumMove) {
            case 3 -> {
                return -10;
            }
            case -3 -> {
                return 10;
            }
            default -> {return  0;}
        }

    }


    public int checkStatus() {
        int trisColumn = 0;
        int trisDiagonale1 = 0;
        int trisDiagonale2 = 0;
        int status;
        int trisRow = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) { //O(1) perchè BOARD_WIDTH è una costante
                trisRow += board[i][j];
                trisColumn += board[j][i];
            }

            status = evaluateStatus(trisRow);
            if (status != 0) return status;
            trisRow = 0;

            status = evaluateStatus(trisColumn);
            if (status != 0) return status;
            trisColumn = 0;
            trisDiagonale1 += board[i][i];
            trisDiagonale2 += board[i][BOARD_WIDTH - i - 1];
        }
        status = evaluateStatus(trisDiagonale1);
        if (status != 0) return status;
        status = evaluateStatus(trisDiagonale2);
        if (status != 0) return status;
        return status; //non ho ottenuto nessun esito favorevole ai due giocatori
    }

    public void printStatus(int status) {
        if (status < 0) {
            System.out.println("Il giocatore ha vinto");
        } else if (status > 0) {
            System.out.println("Il giocatore ha perso");
        } else {
            System.out.println("Pareggio");
        }
    }

    public int checkAvailableMoves() {
        int counter = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) { //O(1) perchè BOARD_WIDTH è una costante
                if (board[i][j] == 0) {
                    counter++;
                }
            }
        }
        return counter;


    }


    @Override
    public String toString() {
        String tmp = "";

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (board[i][j] == -1) {
                    tmp += "O";
                } else if (board[i][j] == 1) {
                    tmp += "X";
                } else {
                    tmp += " ";
                }

            }
            tmp += "\n----\n";
        }
        return tmp;
    }
}