package persist.implement;

import model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import persist.Interface.moduloDao;

import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */

@Repository("moduloDao")
public class moduloDaoImp implements moduloDao {
    private SessionFactory sessionFactory;
    private static Session session;
@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    private void iniciarSession(){
        session =sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(String s) {
        this.iniciarSession();

        return (Category) session.load(Category.class, Integer.parseInt(s));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        this.iniciarSession();
        Criteria criteria =session.createCriteria(Category.class);
        return criteria.list();
    }

    @Override
    @Transactional
    public Category makePersistent(Category entity) {
        this.iniciarSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @Transactional
    public void makeTrasient(Category entity) {
this.iniciarSession();
        session.delete(entity);
    }
}
