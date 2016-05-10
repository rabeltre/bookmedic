package persist.Interface;

import model.Payment;
import model.Reservation;
import model.Status;

import java.util.List;

/**
 * Created by rabeltre on 3/30/16.
 */
public interface citaDaoMejorada extends GenericoDao<Reservation,String>{
    List<Payment> findAllPayment();
    List<Status>findAllStatus();
}
