public class Main {
    public static void main(String[] args){
        Veicolo[] veicoli= new Veicolo[2];
      veicoli[0]= new Auto();
       veicoli[1] = new Moto();
       veicoli[0].mostraInfo();
        veicoli[1].mostraInfo();
        // System.out.println(veicoli.length);
    }
}
