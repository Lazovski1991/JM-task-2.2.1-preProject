package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    void add(User user, long carId);

    User getUserCar(String model, int series);
}
