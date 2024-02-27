package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Employee employee=new Employee(101,"Ajay","Delhi");
        System.out.println(employee);

        Address address=new Address();
        address.setStreet("street 1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(12.12);
        try {
            //Reading Image
            FileInputStream fileInputStream=new FileInputStream("src/main/resources/a.png");
            byte[] data=new byte[fileInputStream.available()];
            fileInputStream.read(data);
            address.setImage(data);
        }
        catch (Exception exception){
            System.out.println(exception);
        }

        // to save the emp object in database
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(employee);
        session.save(address);
        transaction.commit();
        session.close();
    }
}
