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


        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password)
                .configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Student_gfg_detail student_gfg_detail=new Student_gfg_detail();
        student_gfg_detail.setGfg_id(101);
        student_gfg_detail.setCollege("LPU");
        student_gfg_detail.setNo_of_problem_solved(20);

        Student student=new Student(1,"ajay","sharma","ajaysharma@gmail.com",student_gfg_detail);
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}