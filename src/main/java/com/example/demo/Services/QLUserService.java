package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.QLUser;

public interface QLUserService {

	void deleteAll();

	void deleteAll(List<QLUser> entities);

	void delete(QLUser entity);

	void deleteById(Long id);

	long count();

	List<QLUser> findAllById(List<Long> ids);

	List<QLUser> findAll();

	boolean existsById(Long id);

	Optional<QLUser> findById(Long id);

	List<QLUser> saveAll(List<QLUser> entities);

	QLUser save(QLUser entity);

	List<QLUser> findlk(String name);

	List<QLUser> findup(String name);

	Optional<QLUser> find(long id);

	List<QLUser> getAll();

	void isdeletes(long id);

	Optional<QLUser> findtdn(String tendangnhap);

}
