package persist.Interface;

import java.io.Serializable;
import java.util.List;

/**
 * Created by estudiantes on 25/03/16.
 */
public interface GenericoDao <T, ID extends Serializable> {
    T findById(ID id);
    List<T> findAll();
    T makePersistent(T entity);
    void  makeTrasient(T entity);

}
