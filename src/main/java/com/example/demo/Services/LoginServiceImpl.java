package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoginRepository;
import com.example.demo.models.Login;

@Service
public class LoginServiceImpl implements LoginService{
@Autowired
LoginRepository LoginRepository;

@Override
public List<Login> getAll() {
	return LoginRepository.getAll();
}

@Override
public Optional<Login> findten(String name) {
	return LoginRepository.findten(name);
}

@Override
public Optional<Login> find(long id) {
	return LoginRepository.find(id);
}

@Override
public List<Login> findup(String name) {
	return LoginRepository.findup(name);
}

@Override
public List<Login> findlk(String name) {
	return LoginRepository.findlk(name);
}

@Override
public Login  save(Login entity) {
	return LoginRepository.save(entity);
}



@Override
public List<Login>  saveAll(List<Login> entities) {
	return (List<Login>) LoginRepository.saveAll(entities);
}

@Override
public Optional<Login> findById(Long id) {
	return LoginRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return LoginRepository.existsById(id);
}

@Override
public List<Login> findAll() {
	return (List<Login>) LoginRepository.findAll();
}

@Override
public List<Login> findAllById(List<Long> ids) {
	return (List<Login>) LoginRepository.findAllById(ids);
}

@Override
public long count() {
	return LoginRepository.count();
}

@Override
public void deleteById(Long id) {
	LoginRepository.deleteById(id);
}

@Override
public void delete(Login entity) {
	LoginRepository.delete(entity);
}

@Override
public void deleteAll(List<Login> entities) {
	LoginRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	LoginRepository.deleteAll();
}

}
