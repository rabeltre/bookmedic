package persist.implement;

import model.Pacient;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.pacienteDao;

import java.util.List;

/**
 * Created by estudiantes on 25/03/16.
 */
@Repository("pacienteDao")
public class pacienteDaoImp implements pacienteDao {
    private SessionFactory sessionFactory;
    public static Session session;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

public void iniciarSession(){
 session= sessionFactory.getCurrentSession();
}
    @Override
    @Transactional(readOnly = true)
    public Pacient findById(String s) {
        this.iniciarSession();
        return (Pacient) session.load(Pacient.class,Integer.parseInt(s));

    }

    @Override
    @Transactional(readOnly = true)
    public List<Pacient> findAll() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Pacient.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public Pacient makePersistent(Pacient entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @Transactional
    public void makeTrasient(Pacient entity) {
this.iniciarSession();
        session.delete(entity);
    }
}
