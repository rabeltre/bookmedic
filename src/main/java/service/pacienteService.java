package service;

import model.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.pacienteDao;

import java.util.List;

/**
 * Created by estudiantes on 25/03/16.
 */
@Service("pacienteService")
public class pacienteService implements pacienteDao {
    @Autowired
    private pacienteDao pacienteDao;
    @Override
    public Pacient findById(String s) {
        return pacienteDao.findById(s);
    }

    @Override
    public List<Pacient> findAll() {
        return pacienteDao.findAll();
    }

    @Override
    public Pacient makePersistent(Pacient entity) {
        return pacienteDao.makePersistent(entity);
    }

    @Override
    public void makeTrasient(Pacient entity) {
pacienteDao.makeTrasient(entity);
    }

}
