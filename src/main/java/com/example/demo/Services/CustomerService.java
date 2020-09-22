package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Customers;

public interface CustomerService {

	void deleteAll();

	void deleteAll(List<Customers> entities);

	void delete(Customers entity);

	void deleteById(Long id);

	long count();

	List<Customers> findAllById(List<Long> ids);

	List<Customers> findAll();

	boolean existsById(Long id);

	Optional<Customers> findById(Long id);

	List<Customers> saveAll(List<Customers> entities);

	int update( String name, int gender, Date birthday, String email, String phone, String password,
			String address,Long id);

	List<Customers> findByNameLike(String name);

	List<Customers> findlk(String name);

	Customers save(Customers entity);

	List<Customers> findup(String name);

	Optional<Customers> find(long id);

	List<Customers> getAll();

}
