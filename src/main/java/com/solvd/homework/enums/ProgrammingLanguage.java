package com.solvd.homework.enums;

public enum ProgrammingLanguage{
	JAVA( "8" ),
	JAVASCRIPT( "ECMAScript6" ),
	C( "C18" ),
	PYTHON( "3" ),
	RUST( "1.57" ),
	RUBY( "3.0.3" ),
	CSHARP( "7.0" ),
	TYPESCRIPT( "4.5.2" );
	
	private String version;
	
	ProgrammingLanguage( String version ){
		this.version = version;
	}
	
	public String getVersion( ){
		return version;
	}
	
	public void setVersion( String version ){
		this.version = version;
	}
}
