package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.BangChamCong;

public interface BangChamCongService {

	void deleteAll();

	void deleteAll(List<BangChamCong> entities);

	void delete(BangChamCong entity);

	void deleteById(Long id);

	long count();

	List<BangChamCong> findAllById(List<Long> ids);

	List<BangChamCong> findAll();

	boolean existsById(Long id);

	Optional<BangChamCong> findById(Long id);

	List<BangChamCong> saveAll(List<BangChamCong> entities);

	BangChamCong save(BangChamCong entity);

	List<BangChamCong> findup(String name);

	Optional<BangChamCong> find(int id);

	List<BangChamCong> getAll();

	List<BangChamCong> getAll1(Date ngaycham);

}
