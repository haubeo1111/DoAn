package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.BaoHanh;

public interface BaoHanhService {

	void deleteAll();

	void deleteAll(List<BaoHanh> entities);

	void delete(BaoHanh entity);

	void deleteById(Long id);

	long count();

	List<BaoHanh> findAllById(List<Long> ids);

	List<BaoHanh> findAll();

	boolean existsById(Long id);

	Optional<BaoHanh> findById(Long id);

	List<BaoHanh> saveAll(List<BaoHanh> entities);

	BaoHanh save(BaoHanh entity);

	List<BaoHanh> findup(String name);

	Optional<BaoHanh> find(int id);

	List<BaoHanh> getAll();

	Optional<BaoHanh> findma(String mabh);

}
