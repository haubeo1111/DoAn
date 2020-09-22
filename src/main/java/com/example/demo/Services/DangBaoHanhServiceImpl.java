package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DangBaoHanhRepository;
import com.example.demo.models.DangBaoHanh;

@Service
public class DangBaoHanhServiceImpl implements DangBaoHanhService{
@Autowired
DangBaoHanhRepository dangBaoHanhRepository;

@Override
public List<DangBaoHanh> getAll() {
	return dangBaoHanhRepository.getAll();
}

@Override
public Optional<DangBaoHanh> find(long id) {
	return dangBaoHanhRepository.find(id);
}

@Override
public List<DangBaoHanh> findup(String name) {
	return dangBaoHanhRepository.findup(name);
}

@Override
public DangBaoHanh save(DangBaoHanh entity) {
	return dangBaoHanhRepository.save(entity);
}

@Override
public List<DangBaoHanh>  saveAll(List<DangBaoHanh> entities) {
	return (List<DangBaoHanh>) dangBaoHanhRepository.saveAll(entities);
}

@Override
public Optional<DangBaoHanh> findById(Long id) {
	return dangBaoHanhRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return dangBaoHanhRepository.existsById(id);
}

@Override
public List<DangBaoHanh> findAll() {
	return (List<DangBaoHanh>) dangBaoHanhRepository.findAll();
}

@Override
public List<DangBaoHanh> findAllById(List<Long> ids) {
	return (List<DangBaoHanh>) dangBaoHanhRepository.findAllById(ids);
}

@Override
public long count() {
	return dangBaoHanhRepository.count();
}

@Override
public void deleteById(Long id) {
	dangBaoHanhRepository.deleteById(id);
}

@Override
public void delete(DangBaoHanh entity) {
	dangBaoHanhRepository.delete(entity);
}

@Override
public void deleteAll(List<DangBaoHanh> entities) {
	dangBaoHanhRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	dangBaoHanhRepository.deleteAll();
}

}
