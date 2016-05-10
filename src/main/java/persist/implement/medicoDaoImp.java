package persist.implement;

import model.Medic;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.medicoDao;

import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */
@Repository("medicoDao")
public class medicoDaoImp implements medicoDao {
    private SessionFactory sessionFactory;
    private static Session session;
private void iniciarSession(){
    session =sessionFactory.getCurrentSession();
}
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Medic findById(String s) {
        this.iniciarSession();

        return (Medic) session.load(Medic.class,Integer.parseInt(s));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Medic> findAll() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Medic.class);

        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object>soloResult(){
        this.iniciarSession();
        Query query = session.createQuery("select m.name, m.category.name from Medic m");
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findWithSpecialty() {
        this.iniciarSession();
        Query query = session.createQuery("select m.name, " +
                "m.lastname, m.address, m.email, m.phone, m.category.name, m.id " +
                "from Medic m");
        return query.list();
    }

    @Override
    @Transactional
    public Medic makePersistent(Medic entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return null;
    }

    @Override
    @Transactional
    public void makeTrasient(Medic entity) {
        this.iniciarSession();
        session.delete(entity);

    }
}
