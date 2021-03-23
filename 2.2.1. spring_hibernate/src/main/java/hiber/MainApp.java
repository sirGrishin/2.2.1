package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

//      carService.add(new Car("Bmw",1));
//      carService.add(new Car("Bmw",2));
//      carService.add(new Car("Bmw",3));
//      carService.add(new Car("Bmw",4));
//      carService.add(new Car("Bmw",5));

      List<Car> cars = carService.listCars();
      for (Car car: cars){
         System.out.println("Id = " + car.getId());
         System.out.println("Model = " + car.getModel());
         System.out.println("Series = " + car.getSeries());
         System.out.println();
      }

//      userService.add(new User("User123", "Lastname1123", "user1123@mail.ru",new Car("Bmw",1)));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.getUserByCar("Bmw", 1);
      for (User user  : users){
         System.out.println(user.toString());
      }
      List<User> users1 = userService.listUsers();
      for (User user : users1) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }
      userService.getUserByCar("BMW",1);

      context.close();
   }
}
