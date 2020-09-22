package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.LoaiKM;

public interface LoaiKMService {

	void deleteAll();

	void deleteAll(List<LoaiKM> entities);

	void delete(LoaiKM entity);

	void deleteById(Integer id);

	long count();

	List<LoaiKM> findAllById(Iterable<Integer> ids);

	List<LoaiKM> findAll();

	boolean existsById(Integer id);

	Optional<LoaiKM> findById(Integer id);

	List<LoaiKM> saveAll(List<LoaiKM>  entities);

	LoaiKM save(LoaiKM entity);

	List<LoaiKM> findup(String name);

	Optional<LoaiKM> find(int id);

	List<LoaiKM> getAll();

}
