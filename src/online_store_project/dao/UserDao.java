package online_store_project.dao;

import lombok.SneakyThrows;
import online_store_project.entity.Gender;
import online_store_project.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import online_store_project.util.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Integer, User> {

    private static final UserDao INSTANCE = new UserDao();
    private static final String SAVE_USER = "INSERT INTO users(user_name, user_password, email, birthday,gender) VALUES(?, ?, ?,?,?)";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? and user_password = ?";
    private static final String UPDATE_USER = """
            UPDATE users
            SET user_name= ?,
            surname = ?,
            user_password = ?,
            email = ?,
            address = ?,
            phone = ?,
            gender = ?,
            birthday = ?
            WHERE users_id= ?
            RETURNING *
            """;
    private static final String REPLENISH_BALANCE = "UPDATE users SET balance = balance + ? WHERE users_id = ? RETURNING *";
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE users_id = ?";
    private static final String PAYMENT = "UPDATE users SET balance = balance - ? WHERE users_id = ? RETURNING *";
    private static final String FIND_ALL_USERS = "SELECT * FROM users";

    @Override
    public void add(User user) {

    }

    @Override
    public List<User> findAll() {
        try(Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(createUser(resultSet));
            }

            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<User> find(Integer id) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(createUser(resultSet));
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, entity.getUser_name());
            preparedStatement.setObject(2, entity.getUser_password());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getBirthday());
            preparedStatement.setObject(5, String.valueOf(entity.getGender()));

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                entity.setId(generatedKeys.getInt(1));
            }

            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> findUserByEmailAndPassword(String email, String password) {

        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setObject(1, email);
            preparedStatement.setObject(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = UserDao.createUser(resultSet);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User updateUser(User entity) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, entity.getUser_name());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getUser_password());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setString(6, entity.getPhone());
            preparedStatement.setString(7, String.valueOf(entity.getGender()));
            preparedStatement.setString(8, entity.getBirthday());
            preparedStatement.setObject(9, entity.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createUser(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<User> replenishBalance(String amount, int userId) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REPLENISH_BALANCE);
            preparedStatement.setInt(1, Integer.parseInt(amount));
            preparedStatement.setInt(2, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = createUser(resultSet);
                return Optional.of(user);
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public int checkBalance(int totalPrice, int usersId) {
        Optional<User> user = find(usersId);

        if (user.isPresent()) {
            if(totalPrice > user.get().getBalance()) {
                return 0;
            }
        }

        return 1;
    }

    public Optional<User> payment(int totalPrice, int usersId) {
        try (Connection connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(PAYMENT);

            preparedStatement.setInt(1,totalPrice);
            preparedStatement.setInt(2,usersId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(createUser(resultSet));
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public static User createUser(ResultSet resultSet) {
            return User.builder()
                    .email(resultSet.getString("email"))
                    .user_password(resultSet.getString("user_password"))
                    .user_name(resultSet.getString("user_name"))
                    .birthday(resultSet.getString("birthday"))
                    .gender(Gender.valueOf(resultSet.getString("gender")))
                    .phone(resultSet.getString("phone"))
                    .address(resultSet.getString("address"))
                    .surname(resultSet.getString("surname"))
                    .is_blacklisted(resultSet.getBoolean("is_blacklisted"))
                    .id(resultSet.getInt("users_id"))
                    .balance(resultSet.getDouble("balance"))
                    .build();
        }


    public static UserDao getInstance() {
        return INSTANCE;
    }
}
