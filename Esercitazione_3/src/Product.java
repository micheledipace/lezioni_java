import java.util.Scanner;

public class Product {
    private String name;
    private String id;
    private Double price;

    public Product(String name, String id, Double price){
        this.name= name;
        this.id=id;
        this.price=price;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }


    public static Product buildProduct() {
        String name;
        String id;
        double price;
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il nome del prodotto");
        name = input.next();
        System.out.println("Inserisci il codice del prodotto");
        id = input.next();
        System.out.println("Inserisci il prezzo del prodotto");
        price = input.nextDouble();
        return new Product(name, id, price);
    }



    @Override
    public String toString() {
        return "Product{\n" +
                "\t\tname: " + name  +
                "\t\tid: " + id +
                "\t\tprice: " + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true;}
        if (!(obj instanceof Product)){ return false;}
        // casting per riduzione perchè obj è più generale di Person
        Product that = (Product) obj;
        return this.id.equals(that.id);
}}
