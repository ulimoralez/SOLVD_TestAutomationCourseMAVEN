package com.solvd.homework.connection;

import java.util.logging.Logger;

public class Connection{
	private final Logger LOGGER = Logger.getLogger( Connection.class.getName( ) );
	
	public void executeCRUD( String threadName ){
		this.create( threadName );
		this.read( threadName );
		this.update( threadName );
		this.delete( threadName );
	}
	
	public void read( String threadName ){
		LOGGER.info( "The read query: in thread " + threadName + " was executed successfully!" );
	}
	
	public void delete( String threadName ){
		LOGGER.info( "The delete query: in thread" + threadName + " was executed successfully!" );
	}
	
	public void update( String threadName ){
		LOGGER.info( "The update query: in thread" + threadName + " was executed successfully!" );
	}
	
	public void create( String threadName ){
		LOGGER.info( "The create query: in thread" + threadName + " was executed successfully!" );
	}
	
}
