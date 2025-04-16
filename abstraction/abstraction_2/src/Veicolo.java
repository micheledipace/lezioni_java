public abstract class Veicolo {
    protected int velocita;
    protected String colore;
    public abstract void accendiMotore();
    public void mostraInfo(){
        int velocita = this.velocita;
        String colore = this.colore;

        System.out.println("La velocitá del veicolo é:" + velocita);



        System.out.println("Il colore del veicolo é:" + colore);

    }

}