package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.TienLuong;

public interface TienLuongService {

	void deleteAll();

	void deleteAll(List<TienLuong> entities);

	void delete(TienLuong entity);

	void deleteById(Long id);

	long count();

	List<TienLuong> findAllById(List<Long> ids);

	List<TienLuong> findAll();

	boolean existsById(Long id);

	Optional<TienLuong> findById(Long id);

	List<TienLuong> saveAll(List<TienLuong> entities);

	TienLuong save(TienLuong entity);

	List<TienLuong> findup(String name);

	Optional<TienLuong> find(long id);

	List<TienLuong> getAll();

	int ngaylam(Long id);

}
