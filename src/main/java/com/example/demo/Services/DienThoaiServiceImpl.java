package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DienThoaiRepository;
import com.example.demo.models.DienThoai;

@Service
public class DienThoaiServiceImpl implements DienThoaiService{
@Autowired
DienThoaiRepository dienThoaiRepository;

@Override
public List<DienThoai> getAll() {
	return dienThoaiRepository.getAll();
}

@Override
public Optional<DienThoai> find(long id) {
	return dienThoaiRepository.find(id);
}

@Override
public DienThoai save(DienThoai entity) {
	return dienThoaiRepository.save(entity);
}

@Override
public List<DienThoai> findup(String name) {
	return dienThoaiRepository.findup(name);
}

@Override
public List<DienThoai> findlk(String name) {
	return dienThoaiRepository.findlk(name);
}

@Override
public List<DienThoai>  saveAll(List<DienThoai> entities) {
	return (List<DienThoai>) dienThoaiRepository.saveAll(entities);
}

@Override
public List<DienThoai> findByNameLike(String name) {
	return dienThoaiRepository.findByNameLike(name);
}

@Override
public Optional<DienThoai> findById(Long id) {
	return dienThoaiRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return dienThoaiRepository.existsById(id);
}

@Override
public List<DienThoai> findAll() {
	return (List<DienThoai>) dienThoaiRepository.findAll();
}

@Override
public List<DienThoai> findAllById(List<Long> ids) {
	return (List<DienThoai>) dienThoaiRepository.findAllById(ids);
}

@Override
public long count() {
	return dienThoaiRepository.count();
}

@Override
public void deleteById(Long id) {
	dienThoaiRepository.deleteById(id);
}

@Override
public void delete(DienThoai entity) {
	dienThoaiRepository.delete(entity);
}

@Override
public void deleteAll(List<DienThoai> entities) {
	dienThoaiRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	dienThoaiRepository.deleteAll();
}

}
