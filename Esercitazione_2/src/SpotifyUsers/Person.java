package SpotifyUsers;
import SpotifyItems.PlayableItem;

import java.util.Date;
public class Person {

    private String name;
    private String code;
    private String surname;
    private Date birthday;


    public Person(){
        name= "Default Name";
        surname = "Default Surname";
        code = "0000000";
        birthday = new Date();
    }

    public Person(String name, String surname, Date birthday, String code){
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person))return false;
        Person that = (Person) obj; // l'istanza that è uguale ad obj castato come PlayableItem
        return this.code.equals(that.code);
    }
}
