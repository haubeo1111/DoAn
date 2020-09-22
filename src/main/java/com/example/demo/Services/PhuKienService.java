package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PhuKien;

public interface PhuKienService {

	void deleteAll();

	void deleteAll(List<PhuKien> entities);

	void delete(PhuKien entity);

	void deleteById(Long id);

	long count();

	List<PhuKien> findAllById(Iterable<Long> ids);

	List<PhuKien> findAll();

	boolean existsById(Long id);

	Optional<PhuKien> findById(Long id);

	List<PhuKien> saveAll(List<PhuKien> entities);

	

	PhuKien save(PhuKien entity);

	List<PhuKien> findlk(String name);

	List<PhuKien> findup(String name);

	Optional<PhuKien> find(long id);

	List<PhuKien> getAll();

}
