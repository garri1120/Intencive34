package ru.aston.popov_am.task4.DAO;

import ru.aston.popov_am.task4.DataBaseUtil.ConnectionPoolBuilder;
import ru.aston.popov_am.task4.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao<Integer, User>{
    private final ConnectionPoolBuilder connectionPoolBuilder = ConnectionPoolBuilder.getInstance();

    public UserDaoImpl() throws SQLException {
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = connectionPoolBuilder.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userList.add(User.builder().
                        id(rs.getInt(1)).
                        firstname(rs.getString(2)).
                        lastname(rs.getString(3)).
                        phone(rs.getString(4)).
                        email(rs.getString(5))
                       .build());
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }

    @Override
    public Optional<User> findEntityById(Integer id) {
        Connection connection = connectionPoolBuilder.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id=?")){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                user = User.builder().
                        id(rs.getInt(1)).
                        firstname(rs.getString(2)).
                        lastname(rs.getString(3)).
                        email(rs.getString(4)).
                        phone(rs.getString(5))
                .build();
            }
            return Optional.ofNullable(user);
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
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() >= 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }

    @Override
    public User create(User user) {
        Connection connection = connectionPoolBuilder.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (firstname,lastname,email,phone) VALUES (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,user.getFirstname());
            preparedStatement.setString(2,user.getLastname());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.executeUpdate();
            ResultSet res =  preparedStatement.getGeneratedKeys();
            res.next();
            user.setId(res.getInt(1));
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }

    @Override
    public boolean update(User user) {
        Connection connection = connectionPoolBuilder.getConnection();
        String updateQuery = "UPDATE users SET firstname=? , lastname=?, email=?, phone=? where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)){
            preparedStatement.setString(1,user.getFirstname());
            preparedStatement.setString(2,user.getLastname());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.setInt(5, user.getId());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connectionPoolBuilder.releaseConnection(connection);
        }
    }
}
