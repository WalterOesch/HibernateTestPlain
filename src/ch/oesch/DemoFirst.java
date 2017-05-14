package ch.oesch;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;


/**
 * Created by Walter Oesch on 14.05.2017.
 */
public class DemoFirst {
    public static void main(String[] args) {

        try {
            HibernateNative();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void HibernateNative() throws Exception {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setFirstName("Walter");
        student.setAge(43);

        session.save(student);
        session.getTransaction().commit();

        session.close();
    }

    private static void JpaHibernateImplementation() throws Exception {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = new Student();
        student.setFirstName("Eva");
        student.setAge(43);
        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
