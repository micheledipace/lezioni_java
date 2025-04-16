public class Auto extends Veicolo{
   @Override
    public void accendiMotore() {
        System.out.println("Il motore dell'auto si sta accendendo...");
    }

   Auto(){
        velocita = 170;
        colore = "Rosso";

   }
}
