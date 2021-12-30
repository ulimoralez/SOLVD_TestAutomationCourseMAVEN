package com.solvd.homework.classes;

import com.solvd.homework.interfaces.IProfessor;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Professor extends Person implements IProfessor{
	
	private static final Logger LOGGER = Logger.getLogger( Professor.class.getName( ) );
	private final ArrayList< Integer > professorIDs = new ArrayList<>( );
	private final String studyArea;
	private String collegeName;
	private int id;
	private String favouriteBook;
	
	public Professor( int professorID, String firstName, String lastName, String studyArea, String collegeName ){
		this( professorID, firstName, lastName, studyArea );
		this.collegeName = collegeName;
	}
	
	public Professor( int professorID, String firstName, String lastName, String studyArea ){
		super( firstName, lastName );
		this.id = professorID;
		this.studyArea = studyArea;
	}
	
	public Professor( int professorID, String firstName, String lastName, String studyArea, String collegeName,
	                  String gender, int age, String favouriteBook ){
		this( professorID, firstName, lastName, studyArea );
		super.setAge( age );
		super.setGender( gender );
		this.collegeName = collegeName;
		this.favouriteBook = favouriteBook;
	}
	
	public int getId( ){
		return this.id;
	}
	
	public String getFavouriteBook( ){
		return favouriteBook;
	}
	
	//Overriding interface and super class methods
	public void changeId( int professorId ){
		for( Integer professorID : professorIDs ){
			if( professorID == professorId ){
				this.id = professorId;
				break;
			}
		}
	}
	
	@Override
	public void sayHello( String firstName ){
		try{
			LOGGER.info( "Hello! My name is: " + firstName );
		}catch( Exception e ){
			LOGGER.info( "Error in Professor->sayHello: " + e );
		}
	}
	
	@Override
	public void drink( ){
		LOGGER.info( "I like to drink tea" );
	}
	
	@Override
	public String themeToTeach( ){
		return "Java OOP";
	}
	
	public String getCollegeName( ){
		return collegeName;
	}
	
	public void setCollegeName( String collegeName ){
		this.collegeName = collegeName;
	}
}
