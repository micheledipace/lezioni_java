public class Parcel {
    private int weight;
    private Person receiver;

    Parcel (int weight, Person receiver){
        this.weight = weight;
        this.receiver = receiver;
    }

    public Person getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return
                "Peso:" + weight + "kg" +
                "\tDestinatario: " + receiver
                ;
    }

    @Override
    public boolean equals(Object obj) {
       if (obj == this) {return true;}
       if(!( obj instanceof Parcel that)){return false;}
        return that.getReceiver() == this.getReceiver();
    }
}
