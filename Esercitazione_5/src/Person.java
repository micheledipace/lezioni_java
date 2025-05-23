public class Person {
    private String name;
    private String surname;


    Person(String name, String surname){
       this.name = name;
       this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Person" +
                "nome: " + name + '\n' +
                "cognome: " + surname ;

    }
}
