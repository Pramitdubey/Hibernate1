package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Date;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();

        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
//
//        // Use the variables in your application
//        System.out.println("DB Username: " + username);
//        System.out.println("DB Password: " + password);

        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password)
                .configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();


//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Employee employee = new Employee(101, "Ajay", "Delhi");
        System.out.println(employee);

        Address address = new Address();
        address.setStreet("street 1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(12.12);
        try {
            //Reading Image
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/a.png");
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            address.setImage(data);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        // to save the emp object in database
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        session.save(address);
        transaction.commit();
        session.close();
    }
}