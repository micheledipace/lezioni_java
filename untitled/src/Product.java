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
