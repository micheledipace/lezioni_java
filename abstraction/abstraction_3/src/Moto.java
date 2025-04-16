public class Moto extends Veicolo implements Rifornimento{
    public void faiRifornimento(){
        System.out.println("La moto ha completato il rifornimento!");
    }
    public void accendiMotore(){  //perchè non posso mettere static?
        System.out.println("La moto ha acceso il motore!");
    }
    Moto(String targa){
        this.targa=targa;
    }
}
