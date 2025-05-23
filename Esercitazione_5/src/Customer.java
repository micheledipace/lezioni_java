public class Customer extends Person{
   private int id;
   private int quequePlace;

   Customer(String name, String surname, int id){
       super(name, surname);
      this.id = id;
   }

    public int getId() {
        return id;
    }

    public int getQuequePlace() {
        return quequePlace;
    }

    public void setQuequePlace(int quequePlace) {
        this.quequePlace = quequePlace;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj == this) {return true;}
       if (!(obj instanceof Customer that)){return false;}
        return that.getId() == this.id;
    }

    @Override
    public String toString() {
        return
                "id: " + id +
                "\tPosizione in coda: " + quequePlace
                ;
    }
}
