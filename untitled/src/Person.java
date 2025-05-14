import utils.AccountType;

public class Person {
    private String name;
    private String cf;
    private AccountType accountType;

    //è buona norma implementare sia il costruttore di default assieme al costruttore parametrizzato

    public Person(String name, String cf, AccountType accountType){
        this.name=name;
        this.cf=cf;
        this.accountType=accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        String tmp = "";
        switch (accountType) {
            case CLIENTE -> tmp += "Cliente";
            case VENDITORE -> tmp += "Seller";
        }

        return "Person{\n" +
                "\tcf='" + cf +
                "\tname='" + name  +
                "'\taccount type: }'" + tmp + "\n";
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) { return true;}
       if (!(obj instanceof Person)){ return false;}
      // casting per riduzione perchè obj è più generale di Person
        Person that = (Person) obj;
       return this.cf.equals(that.cf);
    }
}
