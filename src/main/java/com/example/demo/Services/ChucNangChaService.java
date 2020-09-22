package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.ChucNangCha;

public interface ChucNangChaService {

	void deleteAll();

	void deleteAll(List<ChucNangCha> entities);

	void delete(ChucNangCha entity);

	void deleteById(Long id);

	long count();

	List<ChucNangCha> findAllById(List<Long> ids);

	List<ChucNangCha> findAll();

	boolean existsById(Long id);

	Optional<ChucNangCha> findById(Long id);

	List<ChucNangCha> saveAll(List<ChucNangCha> entities);

	ChucNangCha save(ChucNangCha entity);

	List<ChucNangCha> findup(String name);

	Optional<ChucNangCha> find(int id);

	List<ChucNangCha> getAll();

}
