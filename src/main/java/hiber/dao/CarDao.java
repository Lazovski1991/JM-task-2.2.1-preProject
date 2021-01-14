package hiber.dao;

import hiber.model.Car;

public interface CarDao {
    Car get(long carId);

    Car get(String model, int series);

    void add(Car car);
}
