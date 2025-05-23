import utils.AccountType;

import java.util.Scanner;

public class Seller extends Person implements Operations {
    private String accountName;
    private Product product;
    private int numSales;

    Seller(String name, String cf,  String accountName) {
        super(name, cf, AccountType.SELLER);
        this.accountName = accountName;
        product = null;
        numSales = 0;
    }

    public String getAccountName() {
        return accountName;
    }

    public Product getProduct() {
        return product; //nullPointerException
    }

    public int getNumSales() {
        return numSales;
    }


    public void setNumSales(int numSales) {
        this.numSales = numSales;
    }

    @Override
    public String toString() {
        return "Seller{\n" + super.toString() + "\n" +
                "\taccountName: " + accountName + "\n" +
                "\tproduct: " + product.toString() + "\n" +
                "\tnumSales: " + numSales +
                '}';
    }

    @Override
    public void addProduct(Product product) {
        if (this.product != null) {
            System.out.println("Esiste già un altro prodotto");
            System.out.println(this.product);
            System.out.println("Sovrascrivere? 1-Si \t2-NO");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            while (option != 1 && option != 2) {
                System.out.println("Devi selezionare una delle opzioni!");
                option = input.nextInt();
            }
            switch (option) {
                case 1:
                    this.product = product;


                case 2:
                    System.out.println("Prodtto non aggiunto!");

            }
        } else {
            this.product = product;
        }

    }

    public Product removeProduct() {
        Product temp = this.product;
        this.product = null;
        return temp;
    }

    //
    public void menu(ECommerceApp eCommerceApp) {
        Scanner input = new Scanner(System.in);
        int option;
        while (true) {
            System.out.println("Menu Venditore");
            System.out.println("\n 1- Aggiungi prodotto");
            System.out.println("\n 2- Rimuovi prodotto");
            System.out.println("\n 3- Visualizza vendite");
            System.out.println("\n 4- Logout");
            option = input.nextInt();
            while (option < 1 || option > 4) {
                System.out.println("Menu Venditore");
                System.out.println("\n 1- Aggiungi prodotto");
                System.out.println("\n 2- Rimuovi prodotto");
                System.out.println("\n 3- Visualizza vendite");
                System.out.println("\n 4- Logout");
                option = input.nextInt();
            }
            switch (option) {
                case 1:
                    addProduct(Product.buildProduct());
                    break;
                case 2:
                    System.out.println("Ho rimosso il prodotto" + removeProduct());
                    break;
                case 3:
                    System.out.println("Hai venduto " + getNumSales() + "prodotti");
                    break;
                case 4:
                    return; // solo con il logout terminerò il menù del venditore
            }
        }

    }
}