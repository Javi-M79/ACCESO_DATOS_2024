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

        Coche coche = new Coche("Alfa Romeo3", "Tonale", "1600", "150", new Ficha("2026", true));

        //Inciciamos la transaccion
        session.beginTransaction();
        session.persist(coche);
        session.getTransaction().commit();
        session.close();

    }


}
