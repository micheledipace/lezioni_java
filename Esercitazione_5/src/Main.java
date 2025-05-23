public class Main {

    public static void main(String[] args){
        Customer customer1 = new Customer("Pippo", "Rossi", 1234);
        Customer customer2 = new Customer("Paperino", "Rossi", 3456);
        Customer customer3 = new Customer("Minnie", "Rossi", 2345);
        Parcel pacco1 = new Parcel(30, customer1);
        Parcel pacco2 = new Parcel(20, customer2);
        Parcel pacco3 = new Parcel(10, customer3);
        PremiumCustomer premiumcustomer1  = new PremiumCustomer("Pluto" , "Rossi", 2347, "mittente", pacco1);
        PremiumCustomer premiumcustomer2 = new PremiumCustomer("Gastone" , "Rossi", 2348, "mittente", pacco2);
        PremiumCustomer premiumcustomer3 = new PremiumCustomer("Pietro" , "Rossi", 2349, "mittente", pacco3);

        PostOffice postOffice= new PostOffice();

        postOffice.quequeAdd(customer1);
        postOffice.quequeAdd(customer2);
        postOffice.quequeAdd(customer3);
        postOffice.stackAdd(pacco1);
        postOffice.stackAdd(pacco2);
        postOffice.stackAdd(pacco3);
        System.out.println(postOffice.quequeRemove());
        System.out.println(postOffice.quequeRemove());
        System.out.println(postOffice.quequeRemove());
        System.out.println(postOffice.stackRemove());
        System.out.println(postOffice.stackRemove());
        System.out.println(postOffice.stackRemove());

    }

}
