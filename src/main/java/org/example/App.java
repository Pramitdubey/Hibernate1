package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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

//        // Use the variables in your application
//        System.out.println("DB Username: " + username);
//        System.out.println("DB Password: " + password);

        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password)
                .configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Address address=new Address("Street 1", "Delhi");
        Employee employee=new Employee(1001,"Vijay",address);
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}