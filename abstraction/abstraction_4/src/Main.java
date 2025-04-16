public class Main {
    public static void main(String[] args){
       CartaDiCredito Conto_1 = new CartaDiCredito();
       CartaDiCredito Conto_PayPal = new PayPal();
       Conto_PayPal.carica_conto(69.99);
       Conto_1.carica_conto(69.99);
       Conto_1.paga(70.01);
       Conto_PayPal.paga(70.01);
    }
}
