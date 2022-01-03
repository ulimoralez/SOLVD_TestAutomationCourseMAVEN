package com.solvd.homework.connection;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ConnectionRunner{
	public static final ConncetionPool CONNECTION_POOL = ConncetionPool.getInstance( 5 );
	private static final Logger LOGGER = Logger.getLogger( ConnectionRunner.class.getName( ) );
	private static final int TIMEOUT = 1000;
	private static final int EXECUTE_QUERY_TIMEOUT = 500;
	
	public static void main( String[] args ){
		Runnable runnable = ( ) -> {
			Thread currentThread = Thread.currentThread( );
			String currentThreadName = currentThread.getName( );
			
			try{
				Thread.sleep( TIMEOUT );
				while( !CONNECTION_POOL.hasAvaiableConnections( ) ){
					LOGGER.info( "" + currentThreadName + " in queue." );
					Thread.sleep( TIMEOUT );
					createConnection( currentThreadName );
				}
				createConnection( currentThreadName );
			}catch( InterruptedException e ){
				LOGGER.severe( e.getMessage( ) );
			}
		};
		run( runnable );
	}
	
	public static void createConnection( String threadName ) throws InterruptedException{
		Connection connection = CONNECTION_POOL.getConnection( );
		connection.executeCRUD( threadName );
		Thread.sleep( EXECUTE_QUERY_TIMEOUT );
		CONNECTION_POOL.releaseConnection( connection );
	}
	
	public static void run( Runnable runnable ){
		ArrayList< Thread > threads = new ArrayList<>( );
		for( int i = 0; i < 5; i++ ){
			threads.add( new Thread( runnable, "Thread: " + i ) );
			threads.get( i ).start( );
		}
	}
}
