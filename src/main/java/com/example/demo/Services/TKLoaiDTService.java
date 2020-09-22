package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TKLoaiDT;

public interface TKLoaiDTService {

	void deleteAll();

	void deleteAll(List<TKLoaiDT> entities);

	void delete(TKLoaiDT entity);

	void deleteById(Long id);

	long count();

	List<TKLoaiDT> findAllById(List<Long> ids);

	List<TKLoaiDT> findAll();

	boolean existsById(Long id);

	Optional<TKLoaiDT> findById(Long id);

	List<TKLoaiDT> saveAll(List<TKLoaiDT> entities);

	

	TKLoaiDT save(TKLoaiDT entity);

	List<TKLoaiDT> findlk(String name);

	List<TKLoaiDT> findup(String name);

	Optional<TKLoaiDT> find(long id);

	List<TKLoaiDT> getAll();

}
