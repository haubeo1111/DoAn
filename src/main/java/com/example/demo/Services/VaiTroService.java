package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.DangKy;
import com.example.demo.models.VaiTro;

public interface VaiTroService {

	void deleteAll();

	void deleteAll(List<VaiTro> entities);

	void delete(VaiTro entity);

	void deleteById(Long id);

	long count();

	List<VaiTro> findAllById(Iterable<Long> ids);

	List<VaiTro> findAll();

	boolean existsById(Long id);

	Optional<VaiTro> findById(Long id);

	List<VaiTro> saveAll(List<VaiTro> entities);

	VaiTro save(VaiTro entity);

	List<VaiTro> findlk(String name);

	List<VaiTro> findup(String name);

	Optional<VaiTro> find(long id);

	List<VaiTro> getAll();

	void isdeletes(long id);

	int update(String tenvt, String mavt, Long id);

	

}
