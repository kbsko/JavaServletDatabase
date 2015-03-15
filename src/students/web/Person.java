package students.web;

/**
 * Created by Kubish on 15.03.15.
 */
public class Person {
   private String name;
   private int age;

    public void setPerson(String name1, int age1) {
        name = name1;
        age = age1;
    }

    public String getPersonName() {
        return name;
    }
    public int getPersonAge() {
        return age;
    }

}