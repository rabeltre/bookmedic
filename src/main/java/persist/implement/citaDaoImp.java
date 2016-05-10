package persist.implement;

import model.Payment;
import model.Reservation;
import model.Status;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.citaDao;

import java.util.List;

/**
 * Created by root on 3/29/16.
 */
@Repository("citaDao")
public class citaDaoImp implements citaDao {
    private SessionFactory sessionFactory;
    private static Session session;

    private void iniciarSession() {
        session = sessionFactory.getCurrentSession();
    }


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservation findById(String s) {
        this.iniciarSession();
        return (Reservation) session.load(Reservation.class, Integer.parseInt(s));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Reservation.class);
        return criteria.list();
    }
    @Override
    @Transactional(readOnly = true)
    public List<Payment> findAllPayment() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Payment.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Status> findAllStatus() {
        this.iniciarSession();
        Criteria criteria = session.createCriteria(Status.class);
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findByMedic(String id) {
        this.iniciarSession();
        Query query = session.createQuery("select r.id, r.title, r.pacient.name, r.medic.name, r.dateAt, r.timeAt, r.pacient.lastname, r.medic.lastname  from Reservation r " +
                "where r.medic.id=:id");
        query.setParameter("id", Integer.parseInt(id));
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findByPacient(String id) {
        this.iniciarSession();
        Query query = session.createQuery("select r.id, r.title, r.pacient.name, r.medic.name, r.dateAt, r.timeAt, r.pacient.lastname, r.medic.lastname  from Reservation r " +
                "where r.pacient.id=:id");
        query.setParameter("id", Integer.parseInt(id));
        return query.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object> findByPacientOrMedic(String id, String opcion) {
        this.iniciarSession();
        Query query = session.createQuery("select r.id, r.title, r.pacient.name, r.medic.name, r.dateAt, r.timeAt, r.pacient.lastname, r.medic.lastname  from Reservation r " +
                "where r."+opcion+".id=:id");
        query.setParameter("id", Integer.parseInt(id));
        return query.list();
    }

    @Override
    @Transactional
    public Reservation makePersistent(Reservation entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @Transactional
    public void makeTrasient(Reservation entity) {
        this.iniciarSession();
        session.delete(entity);
    }


}
