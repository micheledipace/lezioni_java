public interface Operations {
     void addProduct(Product product);
    Product removeProduct();
    // il parametro é fondamentale se vogliamo implementare una interazione tra cliente e venditore
    void menu(ECommerceApp eCommerceApp);
}
