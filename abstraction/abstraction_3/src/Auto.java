public class Auto extends Veicolo implements Rifornimento{
    public void faiRifornimento(){
        System.out.println("La macchina ha completato il rifornimento!");
    }
    public void accendiMotore() {  //perchè non posso mettere static?
        System.out.println("La macchina ha acceso il motore!");
    }
        Auto(String targa){
            this.targa=targa;
        }
    }
