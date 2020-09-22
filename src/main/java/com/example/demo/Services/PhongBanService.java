package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PhongBan;

public interface PhongBanService {

	void deleteAll();

	void deleteAll(List<PhongBan> entities);

	void delete(PhongBan entity);

	void deleteById(Long id);

	long count();

	List<PhongBan> findAllById(List<Long> ids);

	List<PhongBan> findAll();

	boolean existsById(Long id);

	Optional<PhongBan> findById(Long id);

	List<PhongBan> findByNameLike(String name);

	List<PhongBan> saveAll(List<PhongBan> entities);

	List<PhongBan> findlk(String name);

	List<PhongBan> findup(String name);

	PhongBan save(PhongBan entity);

	Optional<PhongBan> find(long id);

	List<PhongBan> getAll();

}
