package homework6.classes;

import homework3.interfaces.IHuman;
import homework5.exceptions.InvalidPersonAge;
import homework6.customLogger.CustomLogger;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Child extends Person implements IHuman {

    private CustomLogger customLogger = new CustomLogger(Logger.GLOBAL_LOGGER_NAME);
    File file = new File("src/homework6/Log.txt");

    static{
        final int childAge = 7;
        String favouriteFood = "Pizza";
    }
    public static String FAVOURITE_DRINK = "Grape Juice";

    //Constructors
    public Child(){
        customLogger.setupLogger(file);
    }
    public Child(String firstName, String lastName) {
        super(firstName, lastName);
    }
    //Methods and functions
    //Make a final method does not change anything because anyway this class can't be inherited
    final void sayHello(){
        customLogger.print(Level.FINE,"Helloooo!");
    }
    public static void sayFAvouriteGame(){new CustomLogger(Logger.GLOBAL_LOGGER_NAME).print(Level.FINE,"My favourite game is Minecraft");
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
        customLogger.print(Level.FINE,"I like: "+favouriteFood);
    }
    @Override
    public void drink() {
        customLogger.print(Level.FINE,"I drink: "+FAVOURITE_DRINK);
    }
}
