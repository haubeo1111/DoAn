package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.TangKemRepository;
import com.example.demo.models.TangKem;

@Service
public class TangKemServiceImpl implements TangKemService{
@Autowired
TangKemRepository tangKemRepository;

@Override
public List<TangKem> getAll() {
	return tangKemRepository.getAll();
}

@Override
public Optional<TangKem> find(long id) {
	return tangKemRepository.find(id);
}

@Override
public List<TangKem> findup(String name) {
	return tangKemRepository.findup(name);
}

@Override
public List<TangKem> findlk(String name) {
	return tangKemRepository.findlk(name);
}

@Override
public TangKem save(TangKem entity) {
	return tangKemRepository.save(entity);
}

@Override
public List<TangKem> findByNameLike(String name) {
	return tangKemRepository.findByNameLike(name);
}

@Override
public List<TangKem> saveAll(List<TangKem> entities) {
	return (List<TangKem>) tangKemRepository.saveAll(entities);
}

@Override
public Optional<TangKem> findById(Long id) {
	return tangKemRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return tangKemRepository.existsById(id);
}

@Override
public List<TangKem> findAll() {
	return (List<TangKem>) tangKemRepository.findAll();
}

@Override
public List<TangKem> findAllById(List<Long> ids) {
	return (List<TangKem>) tangKemRepository.findAllById(ids);
}

@Override
public long count() {
	return tangKemRepository.count();
}

@Override
public void deleteById(Long id) {
	tangKemRepository.deleteById(id);
}

@Override
public void delete(TangKem entity) {
	tangKemRepository.delete(entity);
}

@Override
public void deleteAll(List<TangKem> entities) {
	tangKemRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	tangKemRepository.deleteAll();
}

}
