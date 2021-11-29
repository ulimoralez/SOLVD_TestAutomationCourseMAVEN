package com.solvd.homework.classes;


import com.solvd.homework.customlogger.CustomLogger;
import com.solvd.homework.exceptions.*;
import com.solvd.homework.interfaces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Person implements IPerson, IHuman {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    static List<String> favouriteFood = new ArrayList<>();
    private final Logger LOGGER = new CustomLogger(Person.class.getName()).getInitializedLogger();
    private static final Logger STATICLOGGER = new CustomLogger(Person.class.getName()).getInitializedLogger();

    //Constructors
    public Person(){}
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
            LOGGER.severe(new InvalidPersonAge().getMessage());
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
        STATICLOGGER.info(Arrays.toString(favouriteFood.toArray()));
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
            LOGGER.info("Hello! My name is: "+firstName);
        }catch (Exception e){
            LOGGER.info("Error in Person->sayHello: "+e);
        }

    }
    @Override
    public void eat() {
        LOGGER.info("I eat any type of food");
    }
    @Override
    public void drink() {
        LOGGER.info("I drink water");
    }
}
