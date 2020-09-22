package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Hoadon;

public interface HoadonServices {

	void deleteAll();

	void deleteAll(List<Hoadon> entities);

	void delete(Hoadon entity);

	void deleteById(Long id);

	long count();

	List<Hoadon> findAllById(Iterable<Long> ids);

	List<Hoadon> findAll();

	boolean existsById(Long id);

	Optional<Hoadon> findById(Long id);

	List<Hoadon> saveAll(List<Hoadon> entities);

	Hoadon save(Hoadon entity);

	List<Hoadon> findlk(String name);

	List<Hoadon> findup(String name);

	Optional<Hoadon> find(long id);

	List<Hoadon> getAll();

}
