package com.solvd.homework.connection;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ConncetionPool {
    private final Logger LOGGER = Logger.getLogger(ConncetionPool.class.getName());

    private static ConncetionPool instance;

    private final int POSSIBLE_CONNECTIONS;
    private Connection connection;
    private ArrayList<Connection> connectionPool;
    private ArrayList<Connection> inUseConnections;

    //Constructor
    public ConncetionPool(int maxConnections){
        this.POSSIBLE_CONNECTIONS = maxConnections;

        this.connectionPool = new ArrayList<>(POSSIBLE_CONNECTIONS);
        this.inUseConnections = new ArrayList<>(POSSIBLE_CONNECTIONS);

        for (int i = 0; i < POSSIBLE_CONNECTIONS; i++){
            this.connectionPool.add(new Connection());
        }
    }

    //Methods & Functions
    public static ConncetionPool getInstance(){
        if(instance == null){
            instance = new ConncetionPool(5);
        }
        return instance;
    }

    public boolean hasAvaiableConnections(){
        return !connectionPool.isEmpty();
    }

    public synchronized Connection getConnection(){
        if(connectionPool.isEmpty() || inUseConnections.size() > POSSIBLE_CONNECTIONS){
            LOGGER.severe("getConnection -> No avaiable connections.");
            throw new RuntimeException("No avaiable connections.");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        inUseConnections.add(connection);
        return connection;
    }

    public synchronized boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return inUseConnections.remove(connection);
    }
}
