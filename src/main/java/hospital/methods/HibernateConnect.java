package hospital.methods;

import hospital.repo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConnect {


    public static Session session = null;
    public static Transaction tx = null;
    public static SessionFactory factory = null;

    static {

        factory = new Configuration().
                configure("cfg.xml").
                addAnnotatedClass(Branch.class).
                addAnnotatedClass(DischargedPatient.class).
                addAnnotatedClass(Disease.class).
                addAnnotatedClass(Doctor.class).
                addAnnotatedClass(Patient.class).
                buildSessionFactory();


    }
}
