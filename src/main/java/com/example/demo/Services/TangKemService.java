package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TangKem;

public interface TangKemService {

	void deleteAll();

	void deleteAll(List<TangKem> entities);

	void delete(TangKem entity);

	void deleteById(Long id);

	long count();

	List<TangKem> findAllById(List<Long> ids);

	List<TangKem> findAll();

	boolean existsById(Long id);

	Optional<TangKem> findById(Long id);

	List<TangKem> saveAll(List<TangKem> entities);

	List<TangKem> findByNameLike(String name);

	TangKem save(TangKem entity);

	List<TangKem> findlk(String name);

	List<TangKem> findup(String name);

	Optional<TangKem> find(long id);

	List<TangKem> getAll();

}
