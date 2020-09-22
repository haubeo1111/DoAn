package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.DangBaoHanh;

public interface DangBaoHanhService {

	void deleteAll();

	void deleteAll(List<DangBaoHanh> entities);

	void delete(DangBaoHanh entity);

	void deleteById(Long id);

	long count();

	List<DangBaoHanh> findAllById(List<Long> ids);

	List<DangBaoHanh> findAll();

	boolean existsById(Long id);

	Optional<DangBaoHanh> findById(Long id);

	List<DangBaoHanh> saveAll(List<DangBaoHanh> entities);

	DangBaoHanh save(DangBaoHanh entity);

	List<DangBaoHanh> findup(String name);

	Optional<DangBaoHanh> find(long id);

	List<DangBaoHanh> getAll();

}
