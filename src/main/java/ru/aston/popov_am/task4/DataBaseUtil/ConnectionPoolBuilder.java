package ru.aston.popov_am.task4.DataBaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ConnectionPoolBuilder implements ConnectionBuilder{
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static final int poolSize = ConnectionPoolSize.INITIAL_POOL_SIZE.getPoolSize();
    private static  ConnectionPoolBuilder instance = null;

    public ConnectionPoolBuilder(List<Connection> connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static ConnectionPoolBuilder create() throws SQLException {

        List<Connection> pool = new ArrayList<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            pool.add(createConnection());
        }
        return new ConnectionPoolBuilder(pool);
    }
    @Override
    public  Connection getConnection() {
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }
    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    public static Connection createConnection() throws SQLException {
        String url = ResourceBundleUtil.getProperties1("db.url");
        String username = ResourceBundleUtil.getProperties1("db.username");
        String password =  ResourceBundleUtil.getProperties1("db.password");

        return DriverManager.getConnection(url,username,password);
    }
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
    public static ConnectionPoolBuilder getInstance() throws SQLException {
        if(instance == null){
            instance = ConnectionPoolBuilder.create();
        }
        return instance;
    }
}
