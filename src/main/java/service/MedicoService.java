package service;

import model.Medic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.medicoDao;

import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */
@Service("medicoService")
public class MedicoService implements medicoDao{
    @Autowired
    private medicoDao medicoDao;

    @Override
    public Medic findById(String s) {
        return medicoDao.findById(s);
    }

    @Override
    public List<Medic> findAll() {
        return medicoDao.findAll();
    }

    @Override
    public Medic makePersistent(Medic entity) {
        return medicoDao.makePersistent(entity);
    }

    @Override
    public void makeTrasient(Medic entity) {
medicoDao.makeTrasient(entity);
    }

    public List<Object>soloResult(){
        return medicoDao.soloResult();
    }

    @Override
    public List<Object> findWithSpecialty() {
        return medicoDao.findWithSpecialty();
    }
}
