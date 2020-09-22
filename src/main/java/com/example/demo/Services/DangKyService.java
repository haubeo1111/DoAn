package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.models.DangKy;

public interface DangKyService {

	void deleteAll();

	void deleteAll(List<DangKy> entities);

	void delete(DangKy entity);

	<S extends DangKy> List<S> findAll(Example<S> example, Sort sort);

	<S extends DangKy> long count(Example<S> example);

	<S extends DangKy> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteById(Long id);

	long count();

	<S extends DangKy> List<S> findAll(Example<S> example);

	<S extends DangKy> boolean exists(Example<S> example);

	DangKy getOne(Long id);

	void deleteAllInBatch();

	void deleteInBatch(List<DangKy> entities);

	boolean existsById(Long id);

	DangKy saveAndFlush(DangKy entity);

	void flush();

	List<DangKy> saveAll(List<DangKy> entities);

	List<DangKy> findByTendangnhap(String tenchucnang);

	List<DangKy> findAllById(Iterable<Long> ids);

	List<DangKy> findAll();

	List<DangKy> findAll(Sort sort);

	Optional<DangKy> findBytendangnhap(String tendangnhap);

	Page<DangKy> findAll(Pageable pageable);

	Optional<DangKy> findById(Long id);

	int delete(Long id);

	<S extends DangKy> Optional<S> findOne(Example<S> example);

	DangKy save(DangKy entity);

	int update(String tendangnhap, String password, Long id);

	int insert(Long id, String tendangnhap, String password, Integer isdelete);

}
