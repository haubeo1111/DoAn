package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.HDChiTietRepository;
import com.example.demo.models.HDChiTiet;

@Service
public class HDChiTietImpl implements HDChiTietService {
@Autowired
HDChiTietRepository hdChiTietRepository;

@Override
public List<HDChiTiet> getAll() {
	return hdChiTietRepository.getAll();
}

@Override
public Optional<HDChiTiet> find(long id) {
	return hdChiTietRepository.find(id);
}

@Override
public List<HDChiTiet> findup(String name) {
	return hdChiTietRepository.findup(name);
}

@Override
public List<HDChiTiet> findlk(String name) {
	return hdChiTietRepository.findlk(name);
}

@Override
public HDChiTiet save(HDChiTiet entity) {
	return hdChiTietRepository.save(entity);
}

@Override
public List<HDChiTiet>  saveAll(List<HDChiTiet> entities) {
	return (List<HDChiTiet>) hdChiTietRepository.saveAll(entities);
}

@Override
public Optional<HDChiTiet> findById(Long id) {
	return hdChiTietRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return hdChiTietRepository.existsById(id);
}

@Override
public List<HDChiTiet> findAll() {
	return (List<HDChiTiet>) hdChiTietRepository.findAll();
}

@Override
public List<HDChiTiet> findAllById(Iterable<Long> ids) {
	return (List<HDChiTiet>) hdChiTietRepository.findAllById(ids);
}

@Override
public long count() {
	return hdChiTietRepository.count();
}

@Override
public void deleteById(Long id) {
	hdChiTietRepository.deleteById(id);
}

@Override
public void delete(HDChiTiet entity) {
	hdChiTietRepository.delete(entity);
}

@Override
public void deleteAll(List<HDChiTiet> entities) {
	hdChiTietRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	hdChiTietRepository.deleteAll();
}

}
