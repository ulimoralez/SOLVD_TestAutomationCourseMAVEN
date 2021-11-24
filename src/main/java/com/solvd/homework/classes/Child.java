package com.solvd.homework.classes;

import com.solvd.homework.customLogger.MyLogger;
import com.solvd.homework.exceptions.InvalidPersonAge;

import java.util.logging.Logger;

public final class Child extends Person{

    Logger log = new MyLogger(Child.class.getName()).getInitializedLogger();
    static Logger staticLogger = new MyLogger(Child.class.getName()).getInitializedLogger();
    static{
        final int childAge = 7;
        String favouriteFood = "Pizza";
    }
    public static String FAVOURITE_DRINK = "Grape Juice";

    //Constructors
    public Child(){}
    public Child(String firstName, String lastName) {
        super(firstName, lastName);
    }
    //Methods and functions
    //Make a final method does not change anything because anyway this class can't be inherited
    final void sayHello(){
        log.info("Helloooo!");
    }
    public static void sayFAvouriteGame(){
        staticLogger.info("I love to play Minecraft");
    }

    //Overriding interface functions

    @Override
    public void changeInfo(String firstName, String lastName, int age) {
        super.changeInfo(firstName, lastName);
        if(age < 0 || age > 18){
            throw new InvalidPersonAge();
        }
    }

    @Override
    public void eat() {
        log.info("I like: "+favouriteFood);
    }
    @Override
    public void drink() {
        log.info("I drink: "+FAVOURITE_DRINK);
    }
}
