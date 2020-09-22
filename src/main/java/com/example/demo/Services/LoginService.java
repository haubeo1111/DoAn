package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Login;

public interface LoginService {

	void deleteAll();

	void deleteAll(List<Login> entities);

	void delete(Login entity);

	void deleteById(Long id);

	long count();

	List<Login> findAllById(List<Long> ids);

	List<Login> findAll();

	boolean existsById(Long id);

	Optional<Login> findById(Long id);

	List<Login> saveAll(List<Login> entities);

	//List<Login> findByNameLike(String name);

	Login save(Login entity);

	List<Login> findlk(String name);

	List<Login> findup(String name);

	Optional<Login> find(long id);

	List<Login> getAll();

	Optional<Login> findten(String name);

}
