package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoaiPKRepository;
import com.example.demo.models.LoaiPK;


@Service
public class LoaiPKServiceImpl implements LoaiPKService{
@Autowired
LoaiPKRepository loaiPKRepository;
@Override
public List<LoaiPK> getAll() {
	return loaiPKRepository.getAll();
}

@Override
public Optional<LoaiPK> find(String id) {
	return loaiPKRepository.find(id);
}

@Override
public List<LoaiPK> findup(String name) {
	return loaiPKRepository.findup(name);
}

@Override
public List<LoaiPK> findlk(String name) {
	return loaiPKRepository.findlk(name);
}

@Override
public LoaiPK save(LoaiPK entity) {
	return loaiPKRepository.save(entity);
}

@Override
public List<LoaiPK>  saveAll(List<LoaiPK> entities) {
	return (List<LoaiPK>) loaiPKRepository.saveAll(entities);
}

@Override
public Optional<LoaiPK> findById(String id) {
	return loaiPKRepository.findById(id);
}

@Override
public boolean existsById(String id) {
	return loaiPKRepository.existsById(id);
}

@Override
public List<LoaiPK> findAll() {
	return (List<LoaiPK>) loaiPKRepository.findAll();
}

@Override
public List<LoaiPK> findAllById(List<String> ids) {
	return (List<LoaiPK>) loaiPKRepository.findAllById(ids);
}

//@Override
//public String count() {
//	return loaiPKRepository.count();
//}

@Override
public void deleteById(String id) {
	loaiPKRepository.deleteById(id);
}

@Override
public void delete(LoaiPK entity) {
	loaiPKRepository.delete(entity);
}

@Override
public void deleteAll(List<LoaiPK> entities) {
	loaiPKRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	loaiPKRepository.deleteAll();
}
}
