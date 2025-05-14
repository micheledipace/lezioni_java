import java.util.LinkedList;

public class ECommerceApp {
    private LinkedList<Customer> customers;
    private LinkedList<Seller> sellers;

    public ECommerceApp(){
        customers = new LinkedList<>();
        sellers = new LinkedList<>();

    }

    public String gatherProducts(){
        String products = "";
        for (Seller v: sellers){
            v.getProduct(); //gestire il caso in cui il prodotto è null.
            if (v.getProduct() != null) {


                products += v.getProduct();
            }
            else {
                products += "Il venditore: " + v.getAccountName() + "non ha prodotti in vendita ";
            }

        }
        return products;
    }

    public Product findProduct(String id) {
        for (Seller v : sellers){
            if (v.getProduct().getId().equals(id)){
                return v.getProduct();
            }

        }
        return null; // se non c'è alcuna corrispondenza
    }
}
