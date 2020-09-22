package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TangCa;

public interface TangCaService {

	void deleteAll();

	void deleteAll(List<TangCa> entities);

	void delete(TangCa entity);

	void deleteById(Long id);

	long count();

	List<TangCa> findAllById(List<Long> ids);

	List<TangCa> findAll();

	boolean existsById(Long id);

	Optional<TangCa> findById(Long id);

	List<TangCa> saveAll(List<TangCa> entities);

	TangCa save(TangCa entity);

	List<TangCa> findup(String name);

	Optional<TangCa> find(long id);

	List<TangCa> getAll();

}
