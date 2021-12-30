package com.solvd.homework.classes;

import com.solvd.homework.enums.Pets;
import com.solvd.homework.exceptions.InvalidPersonAge;

import java.util.logging.Logger;

public final class Child extends Person{
	
	private static final Logger staticLogger = Logger.getLogger( Child.class.getName( ) );
	private static final int childAge;
	private static final String favouriteFood;
	public static String FAVOURITE_DRINK = "Grape Juice";
	
	static{
		childAge = 7;
		favouriteFood = "Pizza";
	}
	
	private final Logger log = Logger.getLogger( Child.class.getName( ) );
	private final Pets favouritePet = Pets.CAT;
	
	//Constructors
	public Child( ){
	}
	
	public Child( String firstName, String lastName ){
		super( firstName, lastName );
	}
	
	public static void sayFavouriteGame( ){
		staticLogger.info( "I love to play Minecraft" );
	}
	
	//Methods and functions
	//Make a final method does not change anything because anyway this class can't be inherited
	public void sayHello( ){
		log.info( "Helloooo! my name is: " + this.getFirstName( ) + ". Im " + childAge + " years old. My favourite food is " + favouriteFood );
	}
	
	//Overriding interface functions
	
	public void changeInfo( String firstName, String lastName, int age ){
		super.changeInfo( firstName, lastName );
		if( age < 0 || age > 18 ){
			throw new InvalidPersonAge( );
		}
	}
	
	@Override
	public void eat( ){
		log.info( "I like: " + favouriteFood );
	}
	
	@Override
	public void drink( ){
		log.info( "I drink: " + FAVOURITE_DRINK );
	}
	
	public void favouritePet( ){
		log.fine( "My favourite pet is: " + favouritePet );
	}
	
}
