package ru.aston.popov_am.task4.DAO;

import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinedQueriesImpl implements JoinedQueries<Integer>{
    private final ConnectionPoolBuilder connectionPoolBuilder = ConnectionPoolBuilder.getInstance();

    public JoinedQueriesImpl() throws SQLException {
    }


    @Override
    public int sumOfUserOrdersById(Integer id) {
        Connection connection = connectionPoolBuilder.getConnection();
        int sum = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT sum(price) FROM users join orders on users.id = orders.userId where users.id = ?")){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
              rs.next();
              sum = rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
        return sum;
    }
}
