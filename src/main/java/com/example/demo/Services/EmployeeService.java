package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.Employee;

public interface EmployeeService {

	void deleteAll();

	void deleteAll(List<Employee> entities);

	void delete(Employee entity);

	void deleteById(Long id);

	long count();

	List<Employee> findAllById(List<Long> ids);

	List<Employee> findAll();

	boolean existsById(Long id);

	Optional<Employee> findById(Long id);

	List<Employee> saveAll(List<Employee> entities);

	Employee save(Employee entity);
	//boolean isdelete(long id);
	List<Employee> getAll();
	Optional<Employee> find(long id);
	List<Employee> findByNameLike(String name);
	List<Employee> findup(String name);

	void isdeletes(long id);
}
