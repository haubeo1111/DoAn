package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DienThoaiCuRepository;
import com.example.demo.models.DienThoaiCu;

@Service
public class DienThoaiCuServiceImpl implements DienThoaiCuService{
@Autowired
DienThoaiCuRepository dienThoaiCuRepository;

@Override
public List<DienThoaiCu> getAll() {
	return dienThoaiCuRepository.getAll();
}

@Override
public Optional<DienThoaiCu> find(long id) {
	return dienThoaiCuRepository.find(id);
}

@Override
public Optional<DienThoaiCu> findma(String madt) {
	return dienThoaiCuRepository.findma(madt);
}

@Override
public List<DienThoaiCu> findup(String name) {
	return dienThoaiCuRepository.findup(name);
}

@Override
public DienThoaiCu  save(DienThoaiCu entity) {
	return dienThoaiCuRepository.save(entity);
}

@Override
public List<DienThoaiCu>  saveAll(List<DienThoaiCu> entities) {
	return (List<DienThoaiCu>) dienThoaiCuRepository.saveAll(entities);
}

@Override
public Optional<DienThoaiCu> findById(Long id) {
	return dienThoaiCuRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return dienThoaiCuRepository.existsById(id);
}

@Override
public List<DienThoaiCu> findAll() {
	return (List<DienThoaiCu>) dienThoaiCuRepository.findAll();
}

@Override
public List<DienThoaiCu> findAllById(List<Long> ids) {
	return (List<DienThoaiCu>) dienThoaiCuRepository.findAllById(ids);
}

@Override
public long count() {
	return dienThoaiCuRepository.count();
}

@Override
public void deleteById(Long id) {
	dienThoaiCuRepository.deleteById(id);
}

@Override
public void delete(DienThoaiCu entity) {
	dienThoaiCuRepository.delete(entity);
}

@Override
public void deleteAll(List<DienThoaiCu> entities) {
	dienThoaiCuRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	dienThoaiCuRepository.deleteAll();
}

}
