package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;


    @Transactional(readOnly = true)
    @Override
    public Car get(long id) {
        return carDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Car get(String model, int series) {
        return carDao.get(model, series);
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
