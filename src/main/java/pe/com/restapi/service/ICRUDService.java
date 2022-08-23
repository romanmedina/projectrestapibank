package pe.com.restapi.service;

import java.util.List;

public interface ICRUDService<T, V> {

	T add(T obj);
	T update(T obj);
	List<T> getAll();
	T findById(V id);
	boolean delete(V id);
}
