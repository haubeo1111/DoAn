package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

	

	@Override
	public void isdeletes(long id) {
		employeeRepository.isdeletes(id);
	}

	public List<Employee> findup(String name) {
		return employeeRepository.findup(name);
	}

	public List<Employee> findByNameLike(String name) {
		return employeeRepository.findByNameLike(name);
	}

	public Optional<Employee> find(long id) {
		return employeeRepository.find(id);
	}

	public List<Employee> getAll() {
		return employeeRepository.getAll();
	}

	//public boolean isdelete(long id) {
	//	return employeeRepository.isdelete(id);
		 
	//}

	@Override
	public Employee save(Employee entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public List<Employee>  saveAll(List<Employee> entities) {
		return (List<Employee>) employeeRepository.saveAll(entities);
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public List<Employee> findAllById(List<Long> ids) {
		return (List<Employee>) employeeRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return employeeRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void delete(Employee entity) {
		employeeRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Employee> entities) {
		employeeRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		employeeRepository.deleteAll();
	}

   
}
