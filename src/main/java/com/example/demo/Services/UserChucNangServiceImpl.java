package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserChucNangRepository;
import com.example.demo.models.KhuyenMai;
import com.example.demo.models.UserChucNang;

@Service
public class UserChucNangServiceImpl implements UserChucNangService{
@Autowired
UserChucNangRepository UserChucNangRepository;

@Override
public List<UserChucNang> getAll() {
	return UserChucNangRepository.getAll();
}

@Override
public Optional<UserChucNang> findidcn(long id) {
	return UserChucNangRepository.findidcn(id);
}

@Override
public List<UserChucNang> findiduser(long id) {
	return UserChucNangRepository.findiduser(id);
}

@Override
public Optional<UserChucNang> find(long id) {
	return UserChucNangRepository.find(id);
}

@Override
public List<UserChucNang> findup(String name) {
	return UserChucNangRepository.findup(name);
}

@Override
public UserChucNang save(UserChucNang entity) {
	return UserChucNangRepository.save(entity);
}

@Override
public List<UserChucNang>  saveAll(List<UserChucNang> entities) {
	return (List<UserChucNang>) UserChucNangRepository.saveAll(entities);
}

@Override
public Optional<UserChucNang> findById(Long id) {
	return UserChucNangRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return UserChucNangRepository.existsById(id);
}

@Override
public List<UserChucNang> findAll() {
	return (List<UserChucNang>) UserChucNangRepository.findAll();
}

@Override
public List<UserChucNang> findAllById(List<Long> ids) {
	return (List<UserChucNang>) UserChucNangRepository.findAllById(ids);
}

@Override
public long count() {
	return UserChucNangRepository.count();
}

@Override
public void deleteById(Long id) {
	UserChucNangRepository.deleteById(id);
}

@Override
public void delete(UserChucNang entity) {
	UserChucNangRepository.delete(entity);
}

@Override
public void deleteAll(List<UserChucNang> entities) {
	UserChucNangRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	UserChucNangRepository.deleteAll();
}


}
