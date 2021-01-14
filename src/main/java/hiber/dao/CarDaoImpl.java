package hiber.dao;

import hiber.model.Car;
import hiber.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private UserService service;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car get(long carId) {
        return (Car) sessionFactory.getCurrentSession()
                .createQuery("FROM Car WHERE id = :id").setParameter("id", carId).getSingleResult();
    }

    @Override
    public Car get(String model, int series) {
        return (Car) sessionFactory.getCurrentSession()
                .createQuery("FROM Car WHERE model = :model AND series = :series").setParameter("model", model)
                .setParameter("series", series).getSingleResult();
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
