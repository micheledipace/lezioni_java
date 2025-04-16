public class Moto extends Veicolo {
    @Override
public void accendiMotore() {
    System.out.println("Il motore della moto si sta accendendo...");
}

    Moto(){
        velocita = 240;
        colore = "Nero";

    }
}
