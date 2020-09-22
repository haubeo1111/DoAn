package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.DienThoaiCu;

public interface DienThoaiCuService {

	void deleteAll();

	void deleteAll(List<DienThoaiCu> entities);

	void delete(DienThoaiCu entity);

	void deleteById(Long id);

	long count();

	List<DienThoaiCu> findAllById(List<Long> ids);

	List<DienThoaiCu> findAll();

	boolean existsById(Long id);

	Optional<DienThoaiCu> findById(Long id);

	List<DienThoaiCu> saveAll(List<DienThoaiCu> entities);

	DienThoaiCu save(DienThoaiCu entity);

	List<DienThoaiCu> findup(String name);

	Optional<DienThoaiCu> findma(String madt);

	Optional<DienThoaiCu> find(long id);

	List<DienThoaiCu> getAll();

}
