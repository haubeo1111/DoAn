package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.UserChucNang;

public interface UserChucNangService {

	void deleteAll();

	void deleteAll(List<UserChucNang> entities);

	void delete(UserChucNang entity);

	void deleteById(Long id);

	long count();

	List<UserChucNang> findAllById(List<Long> ids);

	List<UserChucNang> findAll();

	boolean existsById(Long id);

	Optional<UserChucNang> findById(Long id);

	List<UserChucNang> saveAll(List<UserChucNang> entities);

	UserChucNang save(UserChucNang entity);

	List<UserChucNang> findup(String name);

	Optional<UserChucNang> find(long id);

	List<UserChucNang> getAll();

	List<UserChucNang> findiduser(long id);

	Optional<UserChucNang> findidcn(long id);

}
