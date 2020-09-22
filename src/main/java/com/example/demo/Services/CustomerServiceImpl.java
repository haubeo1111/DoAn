package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.models.Customers;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
CustomerRepository customerRepository;

@Override
public List<Customers> getAll() {
	return customerRepository.getAll();
}

@Override
public Optional<Customers> find(long id) {
	return customerRepository.find(id);
}

@Override
public List<Customers> findup(String name) {
	return customerRepository.findup(name);
}

@Override
public Customers  save(Customers entity) {
	return customerRepository.save(entity);
}

@Override
public List<Customers> findlk(String name) {
	return customerRepository.findlk(name);
}

@Override
public List<Customers> findByNameLike(String name) {
	return customerRepository.findByNameLike(name);
}

@Override
public int update( String name, int gender, Date birthday, String email, String phone, String password,
		String address,Long id) {
	return customerRepository.update( name, gender, birthday, email, phone, password, address,id);
}

@Override
public List<Customers>  saveAll(List<Customers> entities) {
	return (List<Customers>) customerRepository.saveAll(entities);
}

@Override
public Optional<Customers> findById(Long id) {
	return customerRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return customerRepository.existsById(id);
}

@Override
public List<Customers> findAll() {
	return (List<Customers>) customerRepository.findAll();
}

@Override
public List<Customers> findAllById(List<Long> ids) {
	return (List<Customers>) customerRepository.findAllById(ids);
}

@Override
public long count() {
	return customerRepository.count();
}

@Override
public void deleteById(Long id) {
	customerRepository.deleteById(id);
}

@Override
public void delete(Customers entity) {
	customerRepository.delete(entity);
}

@Override
public void deleteAll(List<Customers> entities) {
	customerRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	customerRepository.deleteAll();
}

}
