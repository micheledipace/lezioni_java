public class CartaDiCredito implements MetodoPagamento {
    protected double saldo = 0.00;
    protected boolean flag = false;
    CartaDiCredito(){

    }


    protected void carica_conto(double saldo){
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }
    public boolean paga (double importo){
        if (importo <= saldo){
            saldo = saldo - importo;
            this.flag = true;
            System.out.println("Il nuovo saldo è" + saldo);
            return this.flag;
        }
        else {
            System.out.println("Errore! l'importo è maggiore del saldo");
            return this.flag;
        }
    }
}
