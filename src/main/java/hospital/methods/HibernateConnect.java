package hospital.methods;

import hospital.repo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConnect {


    static Session session = null;
    static Transaction tx = null;

    static {

        SessionFactory factory = new Configuration().
                configure("cfg.xml").
                addAnnotatedClass(Branch.class).
                addAnnotatedClass(DischargedPatient.class).
                addAnnotatedClass(Disease.class).
                addAnnotatedClass(Doctor.class).
                addAnnotatedClass(Patient.class).
                buildSessionFactory();

        session = factory.openSession();
        tx = session.beginTransaction();

    }
}
