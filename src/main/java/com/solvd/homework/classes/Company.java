package com.solvd.homework.classes;

import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;
import com.solvd.homework.functionalInterfaces.IOperativeSystemProcessor;
import com.solvd.homework.functionalInterfaces.IProgrammingLanguagesProcessor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

public class Company{
	private final Logger LOGGER = Logger.getLogger( Company.class.getName( ) );
	private String name;
	private Date dateOfFoundation;
	private ArrayList< ProgrammingLanguage > programmingLanguages;
	private ArrayList< Programmer > programmersList;
	
	public Company( String name, Date dateOfFoundation, ArrayList< ProgrammingLanguage > programmingLanguages, ArrayList< Programmer > programmersList ){
		this.name = name;
		this.dateOfFoundation = dateOfFoundation;
		this.programmingLanguages = programmingLanguages;
		this.programmersList = programmersList;
	}
	
	public String getName( ){
		return name;
	}
	
	public void setName( String name ){
		this.name = name;
	}
	
	public Date getDateOfFoundation( ){
		return dateOfFoundation;
	}
	
	public void setDateOfFoundation( Date dateOfFoundation ){
		this.dateOfFoundation = dateOfFoundation;
	}
	
	public ArrayList< ProgrammingLanguage > getProgrammingLanguages( ){
		return programmingLanguages;
	}
	
	public void setProgrammingLanguages( ArrayList< ProgrammingLanguage > programmingLanguages ){
		this.programmingLanguages = programmingLanguages;
	}
	
	public ArrayList< Programmer > getProgrammersList( ){
		return programmersList;
	}
	
	public void setProgrammersList( ArrayList< Programmer > programmersList ){
		this.programmersList = programmersList;
	}
	
	public ArrayList< Programmer > getJavaProgrammers( ){
		ArrayList< Programmer > result;
		IProgrammingLanguagesProcessor programmingLanguagesProcessor = programmerList -> {
			ArrayList< Programmer > programmersInJava = new ArrayList<>( );
			programmerList.forEach( programmer -> {
				if( Objects.equals( programmer.getFavoriteLanguage( ), ProgrammingLanguage.JAVA.name( ) ) ){
					LOGGER.info( "Programmer: " + programmer.getFirstName( ) + " " + programmer.getLastName( ) );
					programmersInJava.add( programmer );
				}
			} );
			return programmersInJava;
		};
		result = programmingLanguagesProcessor.getProgrammerIn( this.programmersList );
		return result;
	}
	
	public ArrayList< Programmer > getProgrammersWithOs( OperativeSystem operativeSystem ){
		ArrayList< Programmer > result;
		IOperativeSystemProcessor iOperativeSystemProcessor = ( programmersList, os ) -> {
			ArrayList< Programmer > programmersWithOs = new ArrayList<>( );
			programmersList.forEach( programmer -> {
				if( Objects.equals( programmer.getFavoriteOS( ), os.name( ) ) ){
					LOGGER.info( "Programmer with " + os.name( ) + ". Name: " + programmer.getFirstName( ) + " LastName: " + programmer.getLastName( ) );
					programmersWithOs.add( programmer );
				}
			} );
			return programmersWithOs;
		};
		result = iOperativeSystemProcessor.getProgrammersIn( this.programmersList, operativeSystem );
		return result;
	}
}
