package org.example.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class ConnectionPool {
    private static ConnectionPool instance;
    private BlockingQueue<Connection> pool;
    private int maxPoolSize;
    private Lock lock;

    private ConnectionPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        pool = new ArrayBlockingQueue<>(maxPoolSize);
        lock = new ReentrantLock();
    }

    public static ConnectionPool getInstance(int maxPoolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(maxPoolSize);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException, SQLException {
        lock.lock();
        try {
            if (pool.isEmpty()) {
                ConnectionManager connectionManager = ConnectionManager.getInstance("jdbc:mysql://localhost:3306/mydb1",
                        "root", "Ba@2112#");
                return connectionManager.getConnection();
            } else {
                return pool.take();
            }
        } finally {
            lock.unlock();
        }
    }

    public void releaseConnection(Connection connection) {
        lock.lock();
        try {
            if (pool.size() < maxPoolSize) {
                pool.offer(connection);
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
