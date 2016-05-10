package persist.Interface;

import model.Payment;
import model.Reservation;
import model.Status;

import java.util.List;

/**
 * Created by root on 3/29/16.
 */
public interface citaDao extends GenericoDao<Reservation,String>{
    List<Payment> findAllPayment();
    List<Status>findAllStatus();
    public List<Object>findByMedic(String id);
    public List<Object>findByPacient(String id);
    public List<Object>findByPacientOrMedic(String id, String opcion);
}
