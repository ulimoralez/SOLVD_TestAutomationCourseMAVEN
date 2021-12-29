package com.solvd.homework.classes;

import com.solvd.homework.interfaces.IProfessor;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Professor extends Person implements IProfessor{
	
	private static final Logger LOGGER = Logger.getLogger( Professor.class.getName( ) );
	private String studyArea;
	private String collegeName;
	private int id;
	private ArrayList< Integer > professorIDs = new ArrayList<>( );
	private String favouriteBook;
	
	public Professor( String firstName, String lastName, String studyArea, String collegeName, int professorID ){
		this( firstName, lastName, studyArea );
		this.collegeName = collegeName;
		this.id = professorID;
	}
	
	public Professor( String firstName, String lastName, String studyArea ){
		super( firstName, lastName );
		this.studyArea = studyArea;
	}
	
	public Professor( String firstName, String lastName, String gender, int age, String studyArea, String collegeName,
	                  int professorID, String favouriteBook ){
		this( firstName, lastName, studyArea );
		super.setAge( age );
		super.setGender( gender );
		this.collegeName = collegeName;
		this.id = professorID;
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
		for( int i = 0; i < professorIDs.size( ); i++ ){
			if( professorIDs.get( i ) == professorId ){
				this.id = professorId;
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
}
