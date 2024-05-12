import database.HibernateUtil;
import model.Coche;
import model.Ficha;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;

public class Entrada {


    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Coche coche = new Coche("Alfa Romeo", "Gulietta", "1900", "120", new Ficha("2025", true));
        Coche coche1 = new Coche("Alfa Romeo1", "Gulietta1", "1900", "250", 1);

        //Inciciomas la transaccion
        session.beginTransaction();
        session.persist(coche1);
        session.getTransaction().commit();
        session.close();

    }


}
