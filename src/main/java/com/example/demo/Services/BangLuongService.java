package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.BangLuong;

public interface BangLuongService {

	void deleteAll();

	void deleteAll(List<BangLuong> entities);

	void delete(BangLuong entity);

	void deleteById(Integer id);

	long count();

	List<BangLuong> findAllById(List<Integer> ids);

	List<BangLuong> findAll();

	boolean existsById(Integer id);

	Optional<BangLuong> findById(Integer id);

	List<BangLuong> saveAll(List<BangLuong> entities);

	BangLuong save(BangLuong entity);

	List<BangLuong> findup(String name);

	Optional<BangLuong> find(int id);

	List<BangLuong> getAll();

}
