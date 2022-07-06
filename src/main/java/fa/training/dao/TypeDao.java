package fa.training.dao;

import java.util.List;

import fa.training.entities.Type;

public interface TypeDao {
	List<Type> findAll();
    Type findById(int id);
    void save(Type type);
    void saveAll(List<Type> types);
    void delete(int id);
}
