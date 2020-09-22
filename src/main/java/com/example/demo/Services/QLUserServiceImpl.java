package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.QLUserRepository;
import com.example.demo.models.QLUser;

@Service
public class QLUserServiceImpl implements QLUserService{
@Autowired
QLUserRepository qLUserRepository;

@Override
public void isdeletes(long id) {
	qLUserRepository.isdeletes(id);
}

@Override
public Optional<QLUser> findtdn(String tendangnhap) {
	return qLUserRepository.findtdn(tendangnhap);
}

@Override
public List<QLUser> getAll() {
	return qLUserRepository.getAll();
}

@Override
public Optional<QLUser> find(long id) {
	return qLUserRepository.find(id);
}

@Override
public List<QLUser> findup(String name) {
	return qLUserRepository.findup(name);
}

@Override
public List<QLUser> findlk(String name) {
	return qLUserRepository.findlk(name);
}

@Override
public QLUser save(QLUser entity) {
	return qLUserRepository.save(entity);
}

@Override
public List<QLUser>  saveAll(List<QLUser> entities) {
	return (List<QLUser>) qLUserRepository.saveAll(entities);
}

@Override
public Optional<QLUser> findById(Long id) {
	return qLUserRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return qLUserRepository.existsById(id);
}

@Override
public List<QLUser> findAll() {
	return (List<QLUser>) qLUserRepository.findAll();
}

@Override
public List<QLUser> findAllById(
		List<Long> ids) {
	return (List<QLUser>) qLUserRepository.findAllById(ids);
}

@Override
public long count() {
	return qLUserRepository.count();
}

@Override
public void deleteById(Long id) {
	qLUserRepository.deleteById(id);
}

@Override
public void delete(QLUser entity) {
	qLUserRepository.delete(entity);
}

@Override
public void deleteAll(List<QLUser> entities) {
	qLUserRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	qLUserRepository.deleteAll();
}

}
