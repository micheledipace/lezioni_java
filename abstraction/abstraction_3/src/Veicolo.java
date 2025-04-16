public abstract class Veicolo {
    protected String targa;
   protected abstract void accendiMotore();
   public void stampaTarga(){
      System.out.println(this.targa);
   }
}
