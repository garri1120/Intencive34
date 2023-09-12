package ru.aston.popov_am.task4.DataBaseUtilTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;
import java.sql.SQLException;



public class ConnectionPoolBuilderTest {
    ConnectionPoolBuilder connectionPoolBuilder;
    @BeforeEach
    public void beforeEach() throws SQLException {
        connectionPoolBuilder = ConnectionPoolBuilder.getInstance();
    }

    @Test
    public void getConnectionTest() throws SQLException {
        Assertions.assertTrue(connectionPoolBuilder.getConnection().isValid(1));
    }

    @Test
    public void createTest(){
        Assertions.assertEquals(connectionPoolBuilder.getSize(),10);
    }
}
