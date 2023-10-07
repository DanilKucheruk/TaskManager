package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import entity.User;

public interface Dao<K, T> {
	List<T> findAll();

	Optional<T> findById(K id);

	T save(T entity);
}
