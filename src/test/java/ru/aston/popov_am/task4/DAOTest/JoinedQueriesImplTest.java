package ru.aston.popov_am.task4.DAOTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task4.DAO.JoinedQueriesImpl;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;

import java.sql.SQLException;

public class JoinedQueriesImplTest {
    ConnectionPoolBuilder connectionPoolBuilder;
    JoinedQueriesImpl joinedQueries = new JoinedQueriesImpl();

    public JoinedQueriesImplTest() throws SQLException {
    }

    @BeforeEach
    public void beforeEach() throws SQLException {
        connectionPoolBuilder = ConnectionPoolBuilder.create();

    }

    @Test
    public void sumOfUserOrdersById() {
        Assertions.assertEquals(joinedQueries.sumOfUserOrdersById(3),22000);
    }
}
