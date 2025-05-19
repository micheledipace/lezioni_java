import utils.AccountType;
import utils.EmptyBasketException;
import utils.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



public class Customer extends Person implements Operations {
        private String accountName;
        private double balance;
        private ArrayList<Product> basket;

        Customer(String name, String cf,  String accountName, double balance) {
            super(name, cf, AccountType.CUSTOMER);
            this.accountName = accountName;
            this.balance = balance;
            basket = new ArrayList<>();
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getAccountName() {
            return accountName;
        }

        public void addProduct(Product product) {
            basket.add(product);
        }

        public Product removeProduct() {
            return basket.remove(0);
        }



        private double basketPrice() {
            double sum = 0.0;
            for (Product p : this.basket) {
                sum += p.getPrice();
            }
            return sum;


        }
        public void buyProduct(ECommerceApp eCommerceApp) throws EmptyBasketException, InsufficientBalanceException {
            //check carrello non vuoto
            if (basket.isEmpty()){
                throw new EmptyBasketException("Il carrello é vuoto!");
            }
            double checkoutPrice = basketPrice();
            if (checkoutPrice < balance){

                System.out.println("La transazione é avvenuta con successo");
                while (!basket.isEmpty()) {
                    // per ogni vendita di un prodotto andremo ad informare l'eCommerceApp della vendita avvenuta, aggiornando le statistiche
                    eCommerceApp.sellProduct(removeProduct());
                }
                balance = checkoutPrice - balance;
            }else {
                throw new InsufficientBalanceException("Credito non sufficiente! \n Saldo inferiore di: " + (checkoutPrice - balance) + "$");
                //il cliente puó voler aumentare il credito o rimuovere il prodotto

            }
            //check balance sufficiente

        }
        public void menu(ECommerceApp eCommerceApp) {
            Scanner input = new Scanner(System.in);
            int option;
            while (true) { // ciclo do while
                do {
                    System.out.println("Menu Cliente");
                    System.out.println("\n 1- Aggiungi prodotto al carrello");
                    System.out.println("\n 2- Visualizza prodotti");
                    System.out.println("\n 3- Compra prodotto");
                    System.out.println("\n 4- Aggiorna saldo");
                    System.out.println("\n 5- Logout");
                    option = input.nextInt();
                } while (option < 1 || option > 5);
                switch (option) {
                    case 1:
                        String id = input.next();
                        Product tmp =
                                eCommerceApp.findProduct(id);
                        if (tmp != null){
                            addProduct(tmp);
                        }
                        else {
                            System.out.println("Prodotto non valido!");
                        }
                        break;
                    case 2:
                        seeProducts(eCommerceApp);
                        break;
                    case 3:
                        System.out.println(this);
                        try {
                        buyProduct(eCommerceApp);} catch (EmptyBasketException | InsufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Inserisci il valore da caricare");
                        double newBalance = new Scanner(System.in).nextDouble();
                        setBalance(newBalance);
                        break;
                    case 5:
                        return; // solo con il logout terminerò il menù del venditore
                }
            }

        }

        public void seeProducts(ECommerceApp eCommerceApp){
            System.out.println("Prodotti disponibili : \n");
            System.out.println(eCommerceApp.gatherProducts());
        }




// getProducts
        @Override
        public String toString() {
            String tmp = "[\n";
            for (Product p : basket) {
                //implementare con classe StringBuilder
                Iterator<Product> i = basket.iterator();
                if (!i.hasNext()) {
                    tmp += p + "]";
                }else{
                tmp += p + ", ";}
                return "Customer{\n" + super.toString() + "\n" +
                        "\taccountName: " + accountName + "\n" +
                        "\tbalance: " + balance +
                        '}';
            }
            return tmp;
        }
    }









