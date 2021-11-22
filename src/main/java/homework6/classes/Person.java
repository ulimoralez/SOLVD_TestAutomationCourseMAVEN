package homework6.classes;


import homework6.customLogger.CustomLogger;
import homework6.exceptions.*;
import homework6.interfaces.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person implements IPerson, IHuman {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    static List<String> favouriteFood = new ArrayList<>();
    CustomLogger customLogger = new CustomLogger(Logger.GLOBAL_LOGGER_NAME);
    File file = new File("src/homework6/Log.txt");

    //Constructors
    public Person(){
        customLogger.setupLogger(file);
    }
    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName);
        setAge(age);
    }
    public Person(String firstName, String lastName, String gender) {
        this(firstName, lastName);
        this.gender = gender;
    }
    public Person(String firstName, String lastName, String gender, int age) {
        this(firstName, lastName, gender);
        setAge(age);
    }
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getter and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age > 130 || age < 0){
            throw new InvalidPersonAge();
        }else{
            this.age = age;
        }
    }

    //Methods and Functions
    public void changeInfo(String firstName, String lastName,String gender, int age){
        changeInfo(firstName, lastName);
        this.gender = gender;
        setAge(age);
    }
    public void changeInfo(String firstName, String lastName, int age) {
        changeInfo(firstName, lastName);
        setAge(age);
    }
    public void changeInfo(String firstName, String lastName, String gender){
        changeInfo(firstName, lastName);
        this.gender = gender;
    }
    public void changeInfo(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public static void addFavouriteFood(String food){
        favouriteFood.add(food);
        new CustomLogger(Logger.GLOBAL_LOGGER_NAME).print(Level.FINE,Arrays.toString(favouriteFood.toArray()));
    }

    //Overriding Object Methods
    @Override
    public String toString() {
        return "People{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(gender, person.gender);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, age);
    }

    //Overriding Methods of the interface
    @Override
    public void sayHello(String firstName) {
        try {
            customLogger.print(Level.FINE,"Hello! My name is: "+firstName);
        }catch (Exception e){
            customLogger.print(Level.FINE,"Error in Person->sayHello: "+e);
        }

    }
    @Override
    public void eat() {
        customLogger.print(Level.FINE,"I eat any type of food");
    }
    @Override
    public void drink() {
        customLogger.print(Level.FINE, "I drink water");
    }
}
