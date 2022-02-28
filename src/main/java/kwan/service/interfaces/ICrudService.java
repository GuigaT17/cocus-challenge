package kwan.service.interfaces;

import java.util.List;

public interface ICrudService<T extends Object> {

	T get(Long id);

	List<T> get(String i);

	T save(T entity) throws Exception;

}
