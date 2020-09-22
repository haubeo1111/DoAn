package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PhuCap;

public interface PhuCapService {

	void deleteAll();

	void deleteAll(List<PhuCap> entities);

	void delete(PhuCap entity);

	void deleteById(Long id);

	long count();

	List<PhuCap> findAllById(List<Long> ids);

	List<PhuCap> findAll();

	boolean existsById(Long id);

	Optional<PhuCap> findById(Long id);

	List<PhuCap> saveAll(List<PhuCap> entities);

	PhuCap save(PhuCap entity);

	List<PhuCap> findup(String name);

	Optional<PhuCap> find(int id);

	List<PhuCap> getAll();

}
