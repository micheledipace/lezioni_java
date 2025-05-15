import utils.AccountType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



    public class Customer extends Person implements Operations {
        private String accountName;
        private double balance;
        private ArrayList<Product> basket;

        Customer(String name, String cf, AccountType accountType, String accountName, double balance) {
            super(name, cf, accountType.CUSTOMER);
            this.accountName = accountName;
            this.balance = balance;
            basket = new ArrayList<>();
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

        public void buyProduct() {
            //check carrello non vuoto
            if (basket.get(0).getPrice() < balance){
                balance = basket.get(0).getPrice()- balance;
                System.out.println("La transazione é avvenuta con successo");
                while (!basket.isEmpty()) {
                    basket.remove(0);
                }
            }else {
                System.out.println("Non hai a disposizione credito sufficiente "  + balance);
                //il cliente puó voler aumentare il credito o rimuovere il prodotto
            }
            //check balance sufficiente

        }

        public Product buildProduct() {
            String name;
            String id;
            double price;
            Scanner input = new Scanner(System.in);
            System.out.println("Inserisci il nome del prodotto");
            name = input.next();
            System.out.println("Inserisci il nome del prodotto");
            id = input.next();
            System.out.println("Inserisci il nome del prodotto");
            price = input.nextDouble();
            return new Product(name, id, price);
        }

        public void menu() {
            Scanner input = new Scanner(System.in);
            int option;
            while (true) {
                System.out.println("Menu Cliente");
                System.out.println("\n 1- Aggiungi prodotto");
                System.out.println("\n 2- Rimuovi prodotto");
                System.out.println("\n 3- Compra prodotto");
                System.out.println("\n 4- Logout");
                option = input.nextInt();
                while (option < 1 || option > 4) {
                    System.out.println("Menu Cliente");
                    System.out.println("\n 1- Aggiungi prodotto");
                    System.out.println("\n 2- Rimuovi prodotto");
                    System.out.println("\n 3- Compra prodotto");
                    System.out.println("\n 4- Logout");
                }
                switch (option) {
                    case 1:
                        addProduct(buildProduct());
                    case 2:
                        System.out.println("Ho rimosso il prodotto" + removeProduct());
                    case 3:
                        System.out.println(this);

                        buyProduct();
                    case 4:
                        return; // solo con il logout terminerò il menù del venditore
                }
            }

        }

        @Override
        public String toString() {
            String tmp = "[\n";
            for (Product p : basket) {
                //implementare con classe StringBuilder
                Iterator<Product> i = basket.iterator();
                if (!i.hasNext()) {
                    tmp += p + "]";
                }
                tmp += p + ", ";
                return "Customer{\n" + super.toString() + "\n" +
                        "\taccountName: " + accountName + "\n" +
                        "\tbalance: " + balance +
                        '}';
            }
            return tmp;
        }
    }








