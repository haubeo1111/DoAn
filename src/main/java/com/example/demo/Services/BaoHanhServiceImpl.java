package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BaoHanhRepository;
import com.example.demo.models.BaoHanh;

@Service
public class BaoHanhServiceImpl implements BaoHanhService {
@Autowired
BaoHanhRepository baoHanhRepository ;

@Override
public List<BaoHanh> getAll() {
	return baoHanhRepository.getAll();
}

@Override
public Optional<BaoHanh> find(int id) {
	return baoHanhRepository.find(id);
}

@Override
public Optional<BaoHanh> findma(String mabh) {
	return baoHanhRepository.findma(mabh);
}

@Override
public List<BaoHanh> findup(String name) {
	return baoHanhRepository.findup(name);
}

@Override
public BaoHanh save(BaoHanh entity) {
	return baoHanhRepository.save(entity);
}

@Override
public List<BaoHanh>  saveAll(List<BaoHanh> entities) {
	return (List<BaoHanh>) baoHanhRepository.saveAll(entities);
}

@Override
public Optional<BaoHanh> findById(Long id) {
	return baoHanhRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return baoHanhRepository.existsById(id);
}

@Override
public List<BaoHanh> findAll() {
	return (List<BaoHanh>) baoHanhRepository.findAll();
}

@Override
public List<BaoHanh> findAllById(List<Long> ids) {
	return (List<BaoHanh>) baoHanhRepository.findAllById(ids);
}

@Override
public long count() {
	return baoHanhRepository.count();
}

@Override
public void deleteById(Long id) {
	baoHanhRepository.deleteById(id);
}

@Override
public void delete(BaoHanh entity) {
	baoHanhRepository.delete(entity);
}

@Override
public void deleteAll(List<BaoHanh> entities) {
	baoHanhRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	baoHanhRepository.deleteAll();
}

}
