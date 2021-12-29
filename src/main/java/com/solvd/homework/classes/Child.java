package com.solvd.homework.classes;

import com.solvd.homework.enums.Pets;
import com.solvd.homework.exceptions.InvalidPersonAge;

import java.util.logging.Logger;

public final class Child extends Person{
	
	public static String FAVOURITE_DRINK = "Grape Juice";
	private static Logger staticLogger = Logger.getLogger( Child.class.getName( ) );

	static{
		final int childAge = 7;
		String favouriteFood = "Pizza";
	}
	
	private Logger log = Logger.getLogger( Child.class.getName( ) );
	private Pets favouritePet = Pets.CAT;
	
	//Constructors
	public Child( ){
	}
	
	public Child( String firstName, String lastName ){
		super( firstName, lastName );
	}
	
	public static void sayFAvouriteGame( ){
		staticLogger.info( "I love to play Minecraft" );
	}
	
	//Methods and functions
	//Make a final method does not change anything because anyway this class can't be inherited
	final void sayHello( ){
		log.info( "Helloooo!" );
	}
	
	//Overriding interface functions
	
	@Override
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
