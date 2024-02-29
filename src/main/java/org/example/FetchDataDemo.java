package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDataDemo {
    public static void main(String[] args) {
        // do update this = <property name="hbm2ddl.auto">update</property> in hibernate.cfg.xml
        Dotenv dotenv=Dotenv.configure().load();
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        Configuration configuration=new Configuration()
                .setProperty("hibernate.connection.username",username)
                .setProperty("hibernate.connection.password",password)
                .configure();
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        // get the employee object with id 101
        Employee employee=(Employee)session.load(Employee.class,101);
        System.out.println(employee);
        Address address=(Address) session.load(Address.class,1);
        System.out.println(address);



    }
}
