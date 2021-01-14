package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void add(User user, long carId);

    User getUserModel(String model, int series);
}
