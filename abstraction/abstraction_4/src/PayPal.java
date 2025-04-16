public class PayPal extends CartaDiCredito{

    PayPal(){
        super.flag=true;
    }

    @Override
    public boolean paga (double importo){
        saldo = saldo - importo;
        System.out.println("Il nuovo saldo è" + saldo);
        return flag;
    }
}
