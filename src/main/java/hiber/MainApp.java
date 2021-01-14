package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        carService.add(new Car("ferrary", 5));
        carService.add(new Car("lamba", 3));
        carService.add(new Car("lada", 4));
        carService.add(new Car("audi", 1));

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"), 1);
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"), 2);
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"), 3);
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"), 4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car serial = " + user.getCar().getSeries());
            System.out.println();
        }

        System.out.println(userService.getUserCar("lamba", 3).getFirstName());

        context.close();
    }
}
