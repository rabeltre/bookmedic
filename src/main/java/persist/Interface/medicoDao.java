package persist.Interface;

import model.Medic;

import java.util.List;

/**
 * Created by estudiantes on 27/03/16.
 */
public interface medicoDao extends GenericoDao<Medic,String> {
    public List<Object> soloResult();
    public List<Object> findWithSpecialty();

}
