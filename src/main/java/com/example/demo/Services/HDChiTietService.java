package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.HDChiTiet;

public interface HDChiTietService {

	void deleteAll();

	void deleteAll(List<HDChiTiet> entities);

	void delete(HDChiTiet entity);

	void deleteById(Long id);

	long count();

	List<HDChiTiet> findAllById(Iterable<Long> ids);

	List<HDChiTiet> findAll();

	boolean existsById(Long id);

	Optional<HDChiTiet> findById(Long id);

	List<HDChiTiet> saveAll(List<HDChiTiet> entities);

	HDChiTiet save(HDChiTiet entity);

	List<HDChiTiet> findlk(String name);

	List<HDChiTiet> findup(String name);

	Optional<HDChiTiet> find(long id);

	List<HDChiTiet> getAll();

}
