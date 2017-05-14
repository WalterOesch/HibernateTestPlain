package ch.oesch;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Created by Walter Oesch on 14.05.2017.
 */
public class DemoFirst {
    public static void main(String[] args) {

        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Student student = new Student();
            student.setFirstName("Walter");
            student.setAge(43);

            session.save(student);
            session.getTransaction().commit();

            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
