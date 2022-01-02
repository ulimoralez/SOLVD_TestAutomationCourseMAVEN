package com.solvd.homework.classes;

import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;
import com.solvd.homework.functionalInterfaces.IOperativeSystemProcessor;
import com.solvd.homework.functionalInterfaces.IProgrammingLanguagesProcessor;

import java.util.ArrayList;
import java.util.Date;
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
	
	public ArrayList< Programmer > getJavaProgrammers( IProgrammingLanguagesProcessor programmingLanguagesProcessor ){
		ArrayList< Programmer > result;
		result = programmingLanguagesProcessor.getProgrammerIn( this.programmersList );
		return result;
	}
	
	public ArrayList< Programmer > getProgrammersWithOs( IOperativeSystemProcessor iOperativeSystemProcessor,
	                                                     OperativeSystem operativeSystem ){
		ArrayList< Programmer > result;
		result = iOperativeSystemProcessor.getProgrammersIn( this.programmersList, operativeSystem );
		return result;
	}
}
