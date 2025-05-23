import net.datastructures.LinkedStack;

import java.util.LinkedList;
import java.util.Stack;

public class PostOffice {
    private LinkedList<Customer> customerQueque;
    private LinkedStack<Parcel> parcelStack;

    PostOffice(){
        this.customerQueque = new LinkedList<>();
        this.parcelStack = new LinkedStack<>(); // da libreria
    }



    public void quequeAdd(Customer customer){
        customerQueque.add(customer);
        customer.setQuequePlace(customerQueque.size());
    }
   public String quequeRemove(){
        if(customerQueque.peekFirst() != null){
        return customerQueque.poll().toString();}
        return "Non ci sono persone in coda";
   }

    public void stackAdd(Parcel parcel){
        parcelStack.push(parcel);
    }

    public String stackRemove(){
        return parcelStack.pop().toString();
    }

}
