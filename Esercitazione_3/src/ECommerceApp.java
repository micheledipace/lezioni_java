import java.util.LinkedList;

public class ECommerceApp {
    private LinkedList<Customer> customers;
    private LinkedList<Seller> sellers;

    public ECommerceApp(){
        customers = new LinkedList<>();
        sellers = new LinkedList<>();

    }

    public String gatherProducts(){
        StringBuilder products = new StringBuilder();
        for (Seller v: sellers){
            //v.getProduct(); //gestire il caso in cui il prodotto è null.
            if (v.getProduct() != null) {


                products.append(v.getProduct());
            }
            else {
                products.append("Il venditore: ").append(v.getAccountName()).append("non ha prodotti in vendita ");
            }

        }
        return products.toString();
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
