package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.DienThoai;

public interface DienThoaiService {

	void deleteAll();

	void deleteAll(List<DienThoai> entities);

	void delete(DienThoai entity);

	void deleteById(Long id);

	long count();

	List<DienThoai> findAllById(List<Long> ids);

	List<DienThoai> findAll();

	boolean existsById(Long id);

	Optional<DienThoai> findById(Long id);

	List<DienThoai> findByNameLike(String name);

	List<DienThoai> saveAll(List<DienThoai> entities);

	List<DienThoai> findlk(String name);

	List<DienThoai> findup(String name);

	DienThoai save(DienThoai entity);

	Optional<DienThoai> find(long id);

	List<DienThoai> getAll();

}
