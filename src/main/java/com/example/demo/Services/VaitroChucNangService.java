package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.VaitroChucNang;

public interface VaitroChucNangService {

	void deleteAll();

	void deleteAll(List<VaitroChucNang> entities);

	void delete(VaitroChucNang entity);

	void deleteById(Long id);

	long count();

	List<VaitroChucNang> findAllById(List<Long> ids);

	List<VaitroChucNang> findAll();

	boolean existsById(Long id);

	Optional<VaitroChucNang> findById(Long id);

	List<VaitroChucNang> saveAll(List<VaitroChucNang> entities);

	List<VaitroChucNang> findup(String name);

	VaitroChucNang save(VaitroChucNang entity);

	List<VaitroChucNang> findiduser(long id);

	Optional<VaitroChucNang> findidcn(long id);

	Optional<VaitroChucNang> find(long id);

	List<VaitroChucNang> getAll();

}
