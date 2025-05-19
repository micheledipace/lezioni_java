// Classe mediatrice tra la classe Customer e la classe Seller


import utils.UserNotFoundException;

import java.util.LinkedList;
import java.util.Scanner;

public class ECommerceApp {
    public LinkedList<Customer> customers;
    public LinkedList<Seller> sellers;

    public ECommerceApp(){
        customers = new LinkedList<>();
        sellers = new LinkedList<>();

    }

    public String gatherProducts() {
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
            if(v.getProduct() != null){ // essenziale altrimenti getProduct genererá un errore
            if (v.getProduct().getId().equals(id)){
                return v.getProduct();
            }}

        }
        return null; // se non c'è alcuna corrispondenza
    }

    // si sarebbe dovuta creare una classe Users
    // é l'interfaccia Operazioni che va a stabilire i metodi sia di Seller che di Customer
    private  Operations  findUser(String accountName) throws UserNotFoundException {
       for (Seller s : sellers){
           if (s.getAccountName().equals(accountName)) {
              return s;
           }
       }

        for (Customer c : customers){
            if (c.getAccountName().equals(accountName)) {
                return c;
            }
        }

            throw new UserNotFoundException("Non é stato trovato alcun utente");


    }
// deve permettere il login é il logout dell'utente
    public void menuApp(){
        int option;
        while (true) {
            do {
                System.out.println("Premi 1 per fare il login");
                System.out.println("Premi 2 per fare il logout");
                option = new Scanner(System.in).nextInt();
            } while (option < 1 || option > 2);
            switch (option) {
                case 1:

                    String input = new Scanner(System.in).nextLine();
                    try {
                        this.findUser(input).menu(this);
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Arrivederci.");
                    return;
            }
        }


    }
// l'oggetto deve essere rimosso dal venditore
    public void sellProduct(Product product){
        for (Seller v : sellers){
            if(v.getProduct() != null){ // essenziale altrimenti getProduct genererá un errore
                if (v.getProduct().equals(product)){
                    v.removeProduct();
                    v.setNumSales(v.getNumSales() + 1);
                }}

        }
    }

}
