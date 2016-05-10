package service;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persist.Interface.citaDao;
import persist.Interface.medicoDao;
import persist.Interface.pacienteDao;

import java.util.List;

/**
 * Created by root on 3/30/16.
 */

@Service("citaService")
public class CitaService {
    @Autowired
    private citaDao citaDao;

    @Autowired
    private medicoDao medicoDao;

    @Autowired
    private pacienteDao pacienteDao;
    public List<Medic>findAllMedic(){
        return medicoDao.findAll();
    }
    public List<Pacient> findAllPacient(){
        return pacienteDao.findAll();
    }
    public Reservation findById(String id){
        return citaDao.findById(id);
    }
    public List<Reservation> findAll(){
        return citaDao.findAll();

    }
    public List<Status> findAllStatus(){
        return citaDao.findAllStatus();
    }
    public List<Payment>findAllPayment(){
        return citaDao.findAllPayment();
    }
    public Reservation makePersist(Reservation reservation){
        return citaDao.makePersistent(reservation);
    }

    public List<Object>findByMedic(String id){
        return citaDao.findByMedic(id);
    }
    public List<Object> findByPacient(String id){
        return citaDao.findByPacient(id);
    }
    public List<Object> findByPacientOrMedic(String id, String opcion) {
        return citaDao.findByPacientOrMedic(id, opcion);
    }

}
