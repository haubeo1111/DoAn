package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.LoaiDT;

public interface LoaiDTService {

	void deleteAll();

	void deleteAll(List<LoaiDT> entities);

	void delete(LoaiDT entity);

	void deleteById(String id);

	List<LoaiDT> findAllById(List<String> ids);

	List<LoaiDT> findAll();

	boolean existsById(String id);

	Optional<LoaiDT> findById(String id);

	List<LoaiDT> saveAll(List<LoaiDT> entities);

	LoaiDT save(LoaiDT entity);

	List<LoaiDT> findlk(String name);

	List<LoaiDT> findup(String name);

	Optional<LoaiDT> find(String id);

	List<LoaiDT> getAll();

	

}
