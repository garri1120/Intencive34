package ru.aston.popov_am.task4.DataBaseUtil;

import java.sql.Connection;

public interface ConnectionBuilder {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
}
