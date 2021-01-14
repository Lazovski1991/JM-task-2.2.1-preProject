package hiber.service;

import hiber.model.Car;

public interface CarService {

    Car get(long id);

    Car get(String model, int series);

    void add(Car car);

}
