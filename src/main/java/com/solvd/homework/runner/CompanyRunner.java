package com.solvd.homework.runner;

import com.solvd.homework.classes.Company;
import com.solvd.homework.classes.Programmer;
import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;
import com.solvd.homework.utils.CreatedObjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class CompanyRunner{
	public static void main( String[] args ){
		Logger LOGGER = Logger.getLogger( CompanyRunner.class.getName( ) );
		
		Calendar calendar = Calendar.getInstance( );
		calendar.set( 2000, Calendar.MAY, 22 );
		Date date = calendar.getTime( );
		calendar.set( 2001, Calendar.MAY, 22 );
		
		ArrayList< Programmer > programmers = new ArrayList<>( );
		programmers.add( CreatedObjects.PROGRAMMER1 );
		programmers.add( CreatedObjects.PROGRAMMER2 );
		programmers.add( CreatedObjects.PROGRAMMER3 );
		
		ArrayList< ProgrammingLanguage > programmingLanguages = new ArrayList<>( );
		programmingLanguages.add( ProgrammingLanguage.JAVASCRIPT );
		programmingLanguages.add( ProgrammingLanguage.JAVA );
		programmingLanguages.add( ProgrammingLanguage.CSHARP );
		
		Company company = new Company( "SOLVD", date, programmingLanguages, programmers );
		
		date = calendar.getTime( );
		company.setDateOfFoundation( date );
		
		company.setProgrammersList( programmers );
		company.setProgrammingLanguages( programmingLanguages );
		
		LOGGER.info( "" + company.getProgrammersWithOs( OperativeSystem.WINDOWS ) );
		LOGGER.info( "" + company.getDateOfFoundation( ) );
		LOGGER.info( "" + company.getProgrammingLanguages( ) );
		LOGGER.info( "" + company.getProgrammersList( ) );
		LOGGER.info( "" + company.getJavaProgrammers( ) );
	}
}
