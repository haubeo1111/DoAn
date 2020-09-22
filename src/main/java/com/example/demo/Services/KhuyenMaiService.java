package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.KhuyenMai;

public interface KhuyenMaiService {

	void deleteAll();

	void deleteAll(List<KhuyenMai> entities);

	void delete(KhuyenMai entity);

	void deleteById(Long id);

	long count();

	List<KhuyenMai> findAllById(Iterable<Long> ids);

	Iterable<KhuyenMai> findAll();

	boolean existsById(Long id);

	Optional<KhuyenMai> findById(Long id);

	List<KhuyenMai> saveAll(List<KhuyenMai> entities);

	KhuyenMai save(KhuyenMai entity);

	List<KhuyenMai> findup(String name);

	Optional<KhuyenMai> find(int id);

	List<KhuyenMai> getAll();

}
