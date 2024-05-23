package ejercicio2.controller;

import ejercicio2.database.HibernateUtil;
import ejercicio2.model.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DAOAlumno {

    private SessionFactory sessionFactory;

    public DAOAlumno(){

        sessionFactory = HibernateUtil.getSessionFactory();

    }

    //metodo insertar alumno
    public void insertarAlumno(Alumno alumno){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(alumno);
        session.getTransaction().commit();
        session.close();

    }

}
