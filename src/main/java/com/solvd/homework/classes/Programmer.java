package com.solvd.homework.classes;

import com.solvd.homework.exceptions.InvalidYearsOfExperience;
import com.solvd.homework.interfaces.IProgrammer;

import java.util.Objects;
import java.util.logging.Logger;

public class Programmer extends Person implements IProgrammer{
	private static final Logger LOGGER = Logger.getLogger( Programmer.class.getName( ) );
	private int yearsOfExperience;
	private String favoriteLanguage;
	private String favoriteOS;
	
	//Constructors
	
	public Programmer( String firstName, String lastName, String gender, int yearsOfExperience, String favoriteLanguage, String favoriteOS ){
		super( firstName, lastName, gender );
		changeInfo( yearsOfExperience, favoriteLanguage, favoriteOS );
	}
	
	//Methods and Functions
	public void changeInfo( int yearsOfExperience, String favoriteLanguage, String favoriteOS ){
		this.yearsOfExperience = yearsOfExperience;
		this.favoriteLanguage = favoriteLanguage;
		this.favoriteOS = favoriteOS;
	}
	
	//Getters and Setters
	public int getYearsOfExperience( ){
		return yearsOfExperience;
	}
	
	public void setYearsOfExperience( int yearsOfExperience ) throws InvalidYearsOfExperience{
		if( yearsOfExperience > 70 ){
			LOGGER.severe( new InvalidYearsOfExperience( ).getMessage( ) );
			throw new InvalidYearsOfExperience( );
		}else{
			this.yearsOfExperience = yearsOfExperience;
		}
	}
	
	public String getFavoriteLanguage( ){
		return favoriteLanguage;
	}
	
	public void setFavoriteLanguage( String favoriteLanguage ){
		this.favoriteLanguage = favoriteLanguage;
	}
	
	public String getFavoriteOS( ){
		return favoriteOS;
	}
	
	public void setFavoriteOS( String favoriteOS ){
		this.favoriteOS = favoriteOS;
	}
	
	public void changeInfo( String firstName, String lastName, int yearsOfExperience, String favoriteLanguage,
	                        String favoriteOS ){
		try{
			super.setFirstName( firstName );
			super.setLastName( lastName );
			this.yearsOfExperience = yearsOfExperience;
			this.favoriteLanguage = favoriteLanguage;
			this.favoriteOS = favoriteOS;
		}catch( Exception e ){
			LOGGER.severe( "Error in Programmer->ChangeInfo: " + e );
		}
		
	}
	
	@Override
	public int hashCode( ){
		return Objects.hash( super.hashCode( ), yearsOfExperience, favoriteLanguage, favoriteOS );
	}
	
	@Override
	public boolean equals( Object o ){
		if( this == o ) return true;
		if( o == null || getClass( ) != o.getClass( ) ) return false;
		if( !super.equals( o ) ) return false;
		Programmer that = ( Programmer ) o;
		return yearsOfExperience == that.yearsOfExperience && Objects.equals( favoriteLanguage, that.favoriteLanguage ) && Objects.equals( favoriteOS, that.favoriteOS );
	}
	
	//Overriding Object methods
	@Override
	public String toString( ){
		return "Programmer{" +
				"yearsOfExperience=" + yearsOfExperience +
				", favoriteLanguage='" + favoriteLanguage + '\'' +
				", favoriteOS='" + favoriteOS + '\'' +
				'}';
	}
	
	@Override
	public void eat( ){
		LOGGER.info( "I like to eat vegetables!" );
	}
	
	@Override
	public void drink( ){
		LOGGER.info( "I drink coffee!" );
	}
	
	//Overriding interface methods
	@Override
	public void sayProgrammerQuote( ){
		LOGGER.info( "Work smarter not harder!" );
	}
}
