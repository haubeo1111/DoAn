package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.LoaiPK;

public interface LoaiPKService {

	void deleteAll();

	void deleteAll(List<LoaiPK> entities);

	void delete(LoaiPK entity);

	void deleteById(String id);

	List<LoaiPK> findAllById(List<String> ids);

	List<LoaiPK> findAll();

	boolean existsById(String id);

	Optional<LoaiPK> findById(String id);

	List<LoaiPK> saveAll(List<LoaiPK> entities);

	LoaiPK save(LoaiPK entity);

	List<LoaiPK> findlk(String name);

	List<LoaiPK> findup(String name);

	Optional<LoaiPK> find(String id);

	List<LoaiPK> getAll();

}
