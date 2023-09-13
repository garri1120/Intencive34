package ru.aston.popov_am.task4.DAO;

import ru.aston.popov_am.task4.AppError.InvalidDataException;
import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;
import ru.aston.popov_am.task4.Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl implements OrderDao<Integer, Order> {
    private final ConnectionPoolBuilder connectionPoolBuilder;

    public OrderDaoImpl() throws SQLException {
        this.connectionPoolBuilder = ConnectionPoolBuilder.getInstance();
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        Connection connection = connectionPoolBuilder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                orderList.add(Order.builder().
                        id(rs.getInt(1)).
                        product(rs.getString(2)).
                        price(rs.getInt(3)).
                        userId(rs.getInt(4)).
                        build());
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Order> findEntityById(Integer id) {
        Connection connection = connectionPoolBuilder.getConnection();
        Order order = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM orders WHERE id=?")){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                order = Order.builder().
                        id(rs.getInt(1)).
                        product(rs.getString(2)).
                        price(rs.getInt(3)).
                        userId(rs.getInt(4)).
                        build();
            }
            return Optional.ofNullable(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);

        }
    }

    @Override
    public boolean delete(Integer id) {
        Connection connection = connectionPoolBuilder.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM orders WHERE id=?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }

    @Override
    public Order create(Order order) throws InvalidDataException {
        if(order.getPrice() <= 0){
            throw new InvalidDataException("Не корректно введена цена за товар");
        }
        Connection connection = connectionPoolBuilder.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (product,price,userId) VALUES (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,order.getProduct());
            preparedStatement.setInt(2,order.getPrice());
            preparedStatement.setInt(3,order.getUserId());
            preparedStatement.executeUpdate();
            ResultSet res = preparedStatement.getGeneratedKeys();
            res.next();
            order.setId(res.getInt(1));
            return order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }

    @Override
    public boolean update(Order order) throws InvalidDataException {
        if(order.getPrice()<=0){
            throw new InvalidDataException("Не корректно введена цена за товар");
        }
        Connection connection = connectionPoolBuilder.getConnection();
        String updateQuery = "UPDATE orders SET product=? , price=?, userId=? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
            preparedStatement.setString(1,order.getProduct());
            preparedStatement.setInt(2,order.getPrice());
            preparedStatement.setInt(3,order.getUserId());
            preparedStatement.setInt(4,order.getId());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }
}
