package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.ChucNang;

public interface ChucNangService {

	void deleteAll();

	void deleteAll(List<ChucNang> entities);

	void delete(ChucNang entity);

	void deleteById(Long id);

	long count();

	List<ChucNang> findAllById(List<Long> ids);

	List<ChucNang> findAll();

	boolean existsById(Long id);

	Optional<ChucNang> findById(Long id);

	List<ChucNang> saveAll(List<ChucNang> entities);

	ChucNang save(ChucNang entity);

	List<ChucNang> findup(String name);

	Optional<ChucNang> find(long id);

	List<ChucNang> getAll();

}
