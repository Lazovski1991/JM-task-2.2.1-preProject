package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @Autowired
    private CarService carService;


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public void add(User user, long carId) {
        user.setCar(carService.get(carId));
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserModel(String model, int series) {
        Car car = (carService.get(model, series));
        Long id = car.getId();
        return (User) sessionFactory.getCurrentSession().createQuery("FROM User WHERE cars_id = :id")
                .setParameter("id", id).getSingleResult();
    }
}
