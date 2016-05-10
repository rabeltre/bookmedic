package service;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.moduloDao;

import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */
@Service("moduloService")
public class ModuloService implements moduloDao{
    @Autowired
    private moduloDao moduloDao;


    @Override
    public Category findById(String s) {
        return moduloDao.findById(s);
    }
public void medico(){

}
    @Override
    public List<Category> findAll() {
        return moduloDao.findAll();
    }

    @Override
    public Category makePersistent(Category entity) {
        return moduloDao.makePersistent(entity);
    }

    @Override
    public void makeTrasient(Category entity) {
moduloDao.makeTrasient(entity);
    }
}
