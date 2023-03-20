package org.akademija.six.gui.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final int POOL_SIZE = 10;
    private List<Connection> connectionPool = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionPool() {
        for (int i = 0; i < POOL_SIZE; i++) {
            try {
                String url = ConnectionParam.URL.getValue();
                String username = ConnectionParam.USERNAME.getValue();
                String password = ConnectionParam.PASSWORD.getValue();
                Connection connection = DriverManager.getConnection(url, username, password);
                connectionPool.add(connection);
            } catch (SQLException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    public Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("Nema jarane više konekcija u bazenu");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }



    // SINGLETON -> ANTI PATTERNOM
    private static ConnectionPool instance;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}
