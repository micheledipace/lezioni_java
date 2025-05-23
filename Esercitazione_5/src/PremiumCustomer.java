public class PremiumCustomer extends Customer {
    private String premiumType;
    private Parcel parcel;


    PremiumCustomer(String name, String surname, int id, String premiumType, Parcel parcel){
        super(name, surname, id);
        this.premiumType = premiumType;
        this.parcel = parcel;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\tTipo Premium: " + premiumType
                + "\tPacco: " + parcel;
    }
}
