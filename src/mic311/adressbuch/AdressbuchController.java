package mic311.adressbuch;


import java.util.List;

import mic311.hibernate.session.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;
 
public class AdressbuchController extends HibernateUtil {
 
    public Kontakt add(Kontakt contact) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(contact);
        session.getTransaction().commit();
        return contact;
    }
    public Kontakt delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Kontakt contact = (Kontakt) session.load(Kontakt.class, id);
        if(null != contact) {
            session.delete(contact);
        }
        session.getTransaction().commit();
        return contact;
    }
 
    @SuppressWarnings("unchecked")
	public List<Kontakt> list() {
         
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Kontakt> contacts = null;
        try {
            contacts = (List<Kontakt>)session.createQuery("from Kontakt").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return contacts;
    }
}