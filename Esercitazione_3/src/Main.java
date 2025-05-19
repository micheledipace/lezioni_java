public class Main {
    public static void main(String[] args) {
        Seller s1 = new Seller ("nv1" , "nv1", "seller1");
        Seller s2 = new Seller ("nv1" , "nv1", "seller2");
        Seller s3 = new Seller ("nv1" , "nv1", "seller3");

        Customer c1 = new Customer ("nv1" , "nv1", "customer1", 10.0);
        Customer c2 = new Customer ("nv1" , "nv1", "customer2", 10.0);
        Customer c3 = new Customer ("nv1" , "nv1", "customer3", 10.0);

        ECommerceApp app = new ECommerceApp();
        app.customers.add(c1);
        app.customers.add(c2);
        app.customers.add(c3);

        app.sellers.add(s1);
        app.sellers.add(s2);
        app.sellers.add(s3);

        app.menuApp();
    }
}