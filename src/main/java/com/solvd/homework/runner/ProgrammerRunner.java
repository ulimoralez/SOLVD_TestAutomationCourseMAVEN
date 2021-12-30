package com.solvd.homework.runner;

import com.solvd.homework.enums.OperativeSystem;
import com.solvd.homework.enums.ProgrammingLanguage;
import com.solvd.homework.exceptions.InvalidYearsOfExperience;
import com.solvd.homework.utils.CreatedObjects;

import java.util.logging.Logger;

public class ProgrammerRunner{
	public static void main( String[] args ) throws InvalidYearsOfExperience{
		Logger LOGGER = Logger.getLogger( ProgrammerRunner.class.getName( ) );
		LOGGER.info( "" + CreatedObjects.PROGRAMMER1.getYearsOfExperience( ) );
		LOGGER.info( "" + CreatedObjects.PROGRAMMER1.getFavoriteOS( ) );
		CreatedObjects.PROGRAMMER1.changeInfo( "John", "Wick", 1, ProgrammingLanguage.TYPESCRIPT.name( ),
				OperativeSystem.WINDOWS.name( ) );
		CreatedObjects.PROGRAMMER1.setFavoriteOS( OperativeSystem.LINUX.name( ) );
		CreatedObjects.PROGRAMMER1.setFavoriteLanguage( ProgrammingLanguage.CSHARP.name( ) );
		CreatedObjects.PROGRAMMER1.setYearsOfExperience( 11 );
	}
}
